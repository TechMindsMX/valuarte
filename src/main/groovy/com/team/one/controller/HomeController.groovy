package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired

import javax.validation.Valid
import org.springframework.web.bind.annotation.RequestMapping
import com.team.one.service.ClientService
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.servlet.ModelAndView
import org.springframework.validation.BindingResult
import org.springframework.ui.Model
import com.team.one.command.ContactCommand

@Controller
class HomeController {

    @Autowired
    ClientService clientService

    @RequestMapping("/")
    String getHomePage() {
      return "home/home"
    }

	@RequestMapping("/who")
    String getWhoPage() {
      return "home/who"
    }

    @RequestMapping("/products")
    String getProductsPage() {
      return "home/products"
    }

    @RequestMapping("/mision")
    String getMisionPage() {
      return "home/mision"
    }

    @RequestMapping("/benefits")
    String getBenefitsPage() {
      return "home/benefits"
    }

    @RequestMapping("/contact")
    String getContactPage(Model model) {
      model.addAttribute("contact",new ContactCommand())
      return "home/contact"
    }

    @RequestMapping("/education")
    String getEducationPage() {
      return "home/education"
    }

    @RequestMapping("/privacy")
    String getPrivacyPage() {
      return "home/privacy"
    }

    @RequestMapping("/send")
    ModelAndView sendEmailContacToValuare(@Valid @ModelAttribute("form") ContactCommand contact, BindingResult result) {
      clientService.sendEmailContact(contact)
      def modelAndView = new ModelAndView("redirect:/contact")
      modelAndView.addObject("contact", new ContactCommand())
      modelAndView
    }
}
