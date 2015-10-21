package com.team.one.controller

import org.springframework.beans.factory.annotation.*
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
import com.team.one.service.RewardDataService
import com.team.one.service.SourceService
import com.team.one.service.ClientService
import com.team.one.command.SeguroMedicoCommand
import com.team.one.command.ProjectCommand

@Controller
@RequestMapping("/simulator")
class SimulatorController {

  @Autowired
  SimulatorService simulatorService
  @Autowired
  SimulatorDataService simulatorDataService
  @Autowired
  RewardDataService rewardDataService
  @Autowired
  SourceService sourceService
  @Autowired
  ClientService clientService

  @Value('${path.photos}')
  String pathPhotoUrl

  Logger log = LoggerFactory.getLogger(getClass())

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(method=RequestMethod.GET)
  ModelAndView form(){
    log.info "CREATING simulator"
    def simulatorCommand = new SimulatorCommand()
    simulatorCommand.now = new Date()
  	ModelAndView modelAndView = new ModelAndView("simulator/form")
    modelAndView.addObject("simulatorCommand", simulatorCommand)
    modelAndView.addObject("sources", sourceService.findSources())
    modelAndView
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(method=RequestMethod.POST)
  ModelAndView save(@ModelAttribute("simulator") @Valid SimulatorCommand simulatorCommand, BindingResult bindingResult){
    log.info "SIMULATING ${simulatorCommand.dump()}"
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

    if (simulatorCommand.saved) {
      simulatorService.save(simulator)
    }

    log.info "Valuarte type: ${type}"

    def detailOfPaymentsFromSimulator = simulatorDataService.calculate(simulator)
    rewardDataService.calculate(detailOfPaymentsFromSimulator)

    ModelAndView modelAndView = new ModelAndView("simulator/form")
    modelAndView.addObject("simulatorCommand", simulatorCommand)
    modelAndView.addObject("simulator", simulator)
    modelAndView.addObject("client", client)
    modelAndView.addObject("sources", sourceService.findSources())
    modelAndView.addObject("detailOfPaymentsFromSimulator", detailOfPaymentsFromSimulator)
    modelAndView.addObject("totalCapital", detailOfPaymentsFromSimulator.capital.sum())
    modelAndView.addObject("totalInterest", detailOfPaymentsFromSimulator.interest.sum())
    modelAndView.addObject("totalPayment", simulator.payment * detailOfPaymentsFromSimulator.size())
    modelAndView.addObject("totalIVA", detailOfPaymentsFromSimulator.iva.sum())
    modelAndView.addObject("totalRatio", detailOfPaymentsFromSimulator.ratio.sum())
    modelAndView.addObject("totalReward", detailOfPaymentsFromSimulator.reward.sum())
    modelAndView.addObject("totalInsurance", detailOfPaymentsFromSimulator.insurance.sum())
    modelAndView
  }

  @InitBinder
  void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy", new Locale('es'))
    dateFormat.setLenient(false)
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true))
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/cotizar", method=RequestMethod.POST)
  ModelAndView cotizar(@ModelAttribute("form") SeguroMedicoCommand command){
    log.info "cotizar seguro"
    ProjectCommand product  = clientService.getProductById(command.product.toInteger())
    ModelAndView modelAndView = new ModelAndView("product/show")
    modelAndView.addObject("product", product)
    modelAndView.addObject("pathUrl", pathPhotoUrl)
    modelAndView.addObject("costo", '$5,763.00')
    modelAndView
  }

}
