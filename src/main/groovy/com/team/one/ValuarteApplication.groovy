package com.team.one

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.lightadmin.api.config.LightAdmin
import org.springframework.context.annotation.Bean
import org.apache.catalina.Container
import org.apache.catalina.Context
import org.apache.catalina.Wrapper
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.context.embedded.ServletContextInitializer
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory
import org.springframework.boot.builder.SpringApplicationBuilder
import org.lightadmin.core.config.LightAdminWebApplicationInitializer
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order

import javax.servlet.ServletContext
import javax.servlet.ServletException

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Order(HIGHEST_PRECEDENCE)
class ValuarteApplication extends SpringBootServletInitializer{


    @Value('${lightadmin.backurl}')
    String backToSiteUrl

    static void main(String[] args) {
      SpringApplication.run ValuarteApplication, args
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.source(ValuarteApplication.class)
    }

    @Bean
    ServletContextInitializer servletContextInitializer() {
      return new ServletContextInitializer() {
        @Override
        void onStartup(ServletContext servletContext) throws ServletException {
          LightAdmin.configure(servletContext)
          .basePackage("com.team.one.administration")
          .baseUrl("/admin")
          .security(true)
          .backToSiteUrl(backToSiteUrl)

          new LightAdminWebApplicationInitializer().onStartup(servletContext)
        }

      }
    }

    @Bean
    EmbeddedServletContainerCustomizer servletContainerCustomizer() {
      return new EmbeddedServletContainerCustomizer() {
        @Override
        void customize(ConfigurableEmbeddedServletContainer container) {
          if (container instanceof TomcatEmbeddedServletContainerFactory)
            customizeTomcat((TomcatEmbeddedServletContainerFactory)container)
        }

        private void customizeTomcat(TomcatEmbeddedServletContainerFactory tomcatFactory) {
          tomcatFactory.addContextCustomizers(new TomcatContextCustomizer() {
            @Override
            void customize(Context context) {
              Container jsp = context.findChild("jsp")
              if (jsp instanceof Wrapper)
                  ((Wrapper)jsp).addInitParameter("development","false")
            }

          })
        }

      }
    }


}
