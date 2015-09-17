package com.team.one.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.stereotype.Controller
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.context.request.WebRequest
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import java.util.Optional
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.team.one.service.*
import com.team.one.domain.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.team.one.service.ClientService
import com.team.one.domain.validator.ChangePasswordFormValidator
import com.team.one.command.ResetPasswordCommand
import com.team.one.domain.UserRepository
import com.team.one.domain.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Controller
class LoginController {

  static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class)

  @Autowired
  UserService service
  @Autowired
  RegistrationCodeRepository registrationCodeRepository
  @Autowired
  ClientService clientService
  @Autowired
  ChangePasswordFormValidator changePasswordFormValidator
  @Autowired
  UserRepository userRepository

  @InitBinder("form")
  void initBinder(WebDataBinder binder) {
    binder.addValidators(changePasswordFormValidator);
  }

  @RequestMapping(value="/login", method=RequestMethod.GET)
  ModelAndView index(@RequestParam Optional<String> error){
  	ModelAndView modelAndView = new ModelAndView("login/login")
    if (error.isPresent())
  		modelAndView.addObject("error", "Invalid username and password!")
  	modelAndView
  }

  @RequestMapping(value="/forgot", method=RequestMethod.GET)
  String forgotPassword(){
      return "login/forgotPassword"
  }

  @RequestMapping(value="/forgetPassword", method=RequestMethod.POST)
  String forgetPassword(@RequestParam String email, Model model,HttpServletRequest request) {
    if(!email) {
      model.addAttribute("error","Se requiere agregar un email")
      return "login/forgotPassword"
    }
    def user = service.getUserByEmail(email)
    if(!user) {
      model.addAttribute("error", "El correo electronico no existe en la aplicacionm ")
      return "login/forgotPassword"
    }
    def registrationCode = new RegistrationCode(username: user.username)
    registrationCodeRepository.save(registrationCode)
    def link = generedLink("resetPassword",registrationCode.token,request)
    def map = [email: email, token: link]
    clientService.sendEmailForgotPassword(map)
    return "login/forgotPassword"
  }

  @RequestMapping(value="/resetPassword", method=RequestMethod.GET)
    String resetPassword(@RequestParam String t,Model model){
    String token = t
    def registrationCode = token ? registrationCodeRepository.findByToken(token) : null
    if (!registrationCode) {
      model.addAttribute("error", "La liga de recuperación de contraseña ya fue utilizada")
      return "login/forgotPassword"
    }
    model.addAttribute("to", registrationCode.token)
    return "login/resetPassword"
  }

  @RequestMapping(value="/changePassword", method=RequestMethod.POST)
  String resetPassword(@Valid @ModelAttribute("form") ResetPasswordCommand command, BindingResult bindingResult, Model model){
    if (bindingResult.hasErrors()) {
      def mapErrors = []
      def errores = bindingResult.getGlobalErrors()
      (0..errores.size()-1).each{
        mapErrors.add(errores.get(it).defaultMessage)
      }
      bindingResult.getFieldErrors().each{ error ->
        mapErrors.add("${error.field} ${ error.defaultMessage}")
      }
      model.addAttribute("error", mapErrors.flatten())
      return "login/resetPassword"
    }

    def registrationCode = registrationCodeRepository.findByToken(command.to)
    def username = registrationCode.username
    def user = userRepository.findByUsername(username).get()
    println user
    user.password = new BCryptPasswordEncoder().encode(command.password)
    userRepository.save(user)
    registrationCodeRepository.delete(registrationCode)
    model.addAttribute("success","La contraseña a sido cambiada existosamente")
    return "home/home"
  }

  protected String generedLink(def action, def linkParams, HttpServletRequest request) {
    String uri = request.getScheme() + "://" +
             request.getServerName() +
             ":" +
             request.getServerPort()+ "/" +
             action + "?t=" +linkParams.value
    uri
  }

}
