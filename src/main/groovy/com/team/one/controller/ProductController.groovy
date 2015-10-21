package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.beans.factory.annotation.*
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import com.team.one.service.ClientService
import com.team.one.command.ProjectCommand
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller
@RequestMapping("/product")
class ProductController {

  @Autowired
  ClientService clientService

  @Value('${path.photos}')
  String pathPhotoUrl

  static final Logger log = LoggerFactory.getLogger(this.getClass())

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/show", method=RequestMethod.GET)
  ModelAndView showProduct(@RequestParam("productId") Integer productId) {
    ProjectCommand product  = clientService.getProductById(productId)
    ModelAndView modelAndView = new ModelAndView("product/show")
    modelAndView.addObject("product", product)
    modelAndView.addObject("pathUrl", pathPhotoUrl)
    modelAndView.addObject("productId", product.id)
  	modelAndView
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/", method=RequestMethod.GET)
  String showProducts(Map model) {
    def products = clientService.getProducts()
    def listSectionProducts = products.collate(3)
    model.productGroupList = listSectionProducts
    model.pathUrl = pathPhotoUrl
  	"product/list"
  }

}
