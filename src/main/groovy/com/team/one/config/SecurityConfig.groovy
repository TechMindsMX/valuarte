package com.team.one

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsService

  @Override
  void configure(HttpSecurity http)throws Exception {
    http.csrf().disable()
      .authorizeRequests()
      .antMatchers("/**", "/public/**","/home/**","/Users/**","/assets/**").permitAll()
      .anyRequest().fullyAuthenticated()
      .and()
      .formLogin()
      .loginPage("/login")
      .failureUrl("/login?error=Bad")
      .usernameParameter("username")
      .permitAll()
      .and()
      .logout()
      .logoutUrl("/logout")
      .deleteCookies("remember-me")
      .logoutSuccessUrl("/")
      .permitAll()
      .and()
      .rememberMe()
  }

  @Override
  void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(userDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder())
  }

}
