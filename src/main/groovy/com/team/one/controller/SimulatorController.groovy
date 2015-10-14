package com.team.one.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.ModelAndView
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.validation.BindingResult
import org.springframework.ui.Model
import com.team.one.command.SimulatorCommand
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.web.bind.WebDataBinder
import java.text.SimpleDateFormat
import javax.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.team.one.service.SimulatorService
import com.team.one.service.SimulatorDataService

@Controller
@RequestMapping("/simulator")
class SimulatorController {

  @Autowired
  SimulatorService simulatorService
  @Autowired
  SimulatorDataService simulatorDataService

  Logger log = LoggerFactory.getLogger(getClass())

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(method=RequestMethod.GET)
  String create(Model model){
    log.info "Creating new simulator form"
    def simulatorCommand = new SimulatorCommand()
    simulatorCommand.now = new Date()
    model.addAttribute("simulatorCommand", simulatorCommand)
    "simulator/form"
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(method=RequestMethod.POST)
  ModelAndView save(@Valid @ModelAttribute("simulator") SimulatorCommand simulatorCommand, @RequestParam(required=false, defaultValue="") String type, BindingResult bindingResult){
    log.info "Simulating"
    log.info "Type: ${type}"
  	ModelAndView modelAndView = new ModelAndView("simulator/form")
    Boolean saved

    if (bindingResult.hasErrors()) {
      def mapErrors = []
      bindingResult.getFieldErrors().each{ error ->
        mapErrors.add("${error.field} ${ error.defaultMessage}")
      }
      log.info "We have errors at validate form"
      ModelAndView error =  new ModelAndView("simulator/form","simulatorCommand", simulatorCommand)
      error.addObject("error", mapErrors.flatten())
      return error
    }

    def client = simulatorCommand.bindClient()
    def simulator = simulatorCommand.bindSimulator()
    simulatorService.calculate(simulator)

    if (type.equals("save")) {
      saved = simulatorService.save(simulator)
    }

    def detailOfPaymentsFromSimulator = simulatorDataService.calculate(simulator)
    modelAndView.addObject("simulatorCommand", simulatorCommand)
    modelAndView.addObject("simulator", simulator)
    modelAndView.addObject("client", client)
    modelAndView.addObject("saved", saved)
    modelAndView.addObject("detailOfPaymentsFromSimulator", detailOfPaymentsFromSimulator)
    modelAndView
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value='save', method=RequestMethod.POST)
  ModelAndView save(@ModelAttribute("simulator") SimulatorCommand simulatorCommand){
    log.info "Creating snapshot"
  	ModelAndView modelAndView = new ModelAndView("simulator/form")
    modelAndView.addObject("simulatorCommand", simulatorCommand)
    modelAndView
  }

  @InitBinder
  void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy", new Locale('es'))
    dateFormat.setLenient(false)
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true))
  }

}
