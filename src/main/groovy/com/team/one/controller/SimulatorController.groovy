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

import com.team.one.service.SimulatorService
import com.team.one.service.impl.SimulatorServiceImpl
import com.team.one.service.impl.SimulatorValuarteServiceImpl
import com.team.one.service.SimulatorDataService
import com.team.one.service.RewardDataService
import com.team.one.service.SourceService
import com.team.one.service.ClientService
import com.team.one.command.SeguroMedicoCommand
import com.team.one.command.ProjectCommand
import com.team.one.domain.enums.SimulatorType

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller
@RequestMapping("/simulator")
class SimulatorController {

  @Autowired
  SimulatorDataService simulatorDataService
  @Autowired
  RewardDataService rewardDataService
  @Autowired
  SourceService sourceService
  @Autowired
  ClientService clientService

  @Autowired
  SimulatorServiceImpl simulatorService
  @Autowired
  SimulatorValuarteServiceImpl simulatorValuarteService

  @Value('${path.photos}')
  String pathPhotoUrl

  Logger log = LoggerFactory.getLogger(getClass())

  @PreAuthorize("hasAuthority('ADMIN')")
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

  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(method=RequestMethod.POST)
  ModelAndView save(@ModelAttribute("simulator") @Valid SimulatorCommand simulatorCommand, BindingResult bindingResult){
    log.info "SIMULATING"
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
    def restructure = simulatorService.calculate(simulator)
    def valuarte = simulatorValuarteService.calculate(simulator)

    def detailOfPayments = []
    def detailOfPaymentsRestructure = simulatorDataService.calculate(restructure)
    def detailOfPaymentsValuarte = simulatorDataService.calculate(valuarte)

    if(simulatorCommand.type == SimulatorType.RESTRUCTURE){
      simulator = restructure
      detailOfPayments = detailOfPaymentsRestructure
    } else {
      simulator = valuarte
      detailOfPayments = detailOfPaymentsValuarte
    }

    rewardDataService.calculate(detailOfPayments, detailOfPaymentsRestructure, detailOfPaymentsValuarte)

    if (simulatorCommand.saved) {
      simulator.rows = detailOfPayments
      simulatorService.save(simulator)
    }

    ModelAndView modelAndView = new ModelAndView("simulator/form")
    modelAndView.addObject("simulatorCommand", simulatorCommand)
    modelAndView.addObject("simulator", simulator)
    modelAndView.addObject("client", client)
    modelAndView.addObject("sources", sourceService.findSources())
    modelAndView.addObject("detailOfPayments", detailOfPayments)
    modelAndView.addObject("totalCapital", detailOfPayments.capital.sum())
    modelAndView.addObject("totalInterest", detailOfPayments.interest.sum())
    modelAndView.addObject("totalPayment", simulator.payment * detailOfPayments.size())
    modelAndView.addObject("totalIVA", detailOfPayments.iva.sum())
    modelAndView.addObject("totalRatio", detailOfPayments.ratio.sum())
    modelAndView.addObject("totalReward", detailOfPayments.reward.sum())
    modelAndView.addObject("totalProfit", detailOfPayments.profit.sum())
    modelAndView.addObject("totalCapitalCut", detailOfPayments.capitalCut.sum())
    modelAndView.addObject("totalBalance", detailOfPayments.balance.sum())
    modelAndView.addObject("totalInsurance", detailOfPayments.insurance.sum())
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
