package com.team.one.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.ui.Model
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import org.springframework.security.access.prepost.PreAuthorize

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.validation.Valid

import com.team.one.command.UserCommand
import com.team.one.repository.UserRepository
import com.team.one.domain.User
import com.team.one.domain.validator.UserCreateFormValidator
import com.team.one.service.UserService


@Controller
@RequestMapping("/Users")
class UserController {

  @Autowired
  UserRepository repository
  @Autowired
  UserService userService
  @Autowired
  UserCreateFormValidator userCreateFormValidator

  Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @InitBinder("form")
  void initBinder(WebDataBinder binder) {
    binder.addValidators(userCreateFormValidator);
  }

//  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/create", method=RequestMethod.GET)
  String form(Model model) {
    LOGGER.info("render view Form for userController")
    model.addAttribute("user", new UserCommand())
    "user/form"
  }

//  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/save", method=RequestMethod.POST)
  ModelAndView save(@Valid @ModelAttribute("form") UserCommand form, BindingResult bindingResult) {
    LOGGER.info "begin save of new user"
    if (bindingResult.hasErrors()) {
      def mapErrors = []
      def errores = bindingResult.getGlobalErrors()
      (0..errores.size()-1).each{
        mapErrors.add(errores.get(it).defaultMessage)
      }
      bindingResult.getFieldErrors().each{ error ->
        mapErrors.add("${error.field} ${ error.defaultMessage}")
      }
      LOGGER.info "the method save in userController had a problem in validate form"
      ModelAndView error =  new ModelAndView("user/form","user", form)
      error.addObject("error", mapErrors.flatten())
      return error
    }
    User user = userService.create(form)
    new ModelAndView("redirect:/")
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/", method=RequestMethod.GET)
  ModelAndView index() {
    new ModelAndView("user/show","users",repository.findAll())
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/{userId}", method=RequestMethod.GET)
  ModelAndView show(@PathVariable Long userId) {
    LOGGER.info "Method  show with id ${userId} "
    new ModelAndView("/user/result","user", repository.findById(userId))
  }

}
