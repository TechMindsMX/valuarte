package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {

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
    String getContactPage() {
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
}
