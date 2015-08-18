package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import com.team.one.service.CallService
import com.team.one.command.ProjectCommand

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller
@RequestMapping("/product")
class ProductController {

  @Autowired
  CallService callService

  static final Logger log = LoggerFactory.getLogger(this.getClass())

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/show", method=RequestMethod.GET)
  ModelAndView showProduct(@RequestParam("productId") Integer productId) {
    ProjectCommand product  = callService.getProductById(productId)
    ModelAndView modelAndView = new ModelAndView("product/show")
    modelAndView.addObject("product", product)
  	modelAndView
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/list", method=RequestMethod.GET)
  ModelAndView String showProducts() {
    def products = callService.getProducts()
    ModelAndView modelAndView = new ModelAndView("product/list")
    modelAndView.addObject("products", products)
  	modelAndView
  }

}

