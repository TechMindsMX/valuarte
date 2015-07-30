package com.team.one.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.stereotype.Controller
import org.springframework.web.servlet.ModelAndView
import java.util.Optional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller
class LoginController {

  static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class)

  @RequestMapping(value="/login", method=RequestMethod.GET)
  ModelAndView index(@RequestParam Optional<String> error){
  	//new ModelAndView("login/index", "error", error)
  	ModelAndView modelAndView = new ModelAndView("login/index")
  	if (error)
  		modelAndView.addObject("error", error)
  	modelAndView
  }

}
