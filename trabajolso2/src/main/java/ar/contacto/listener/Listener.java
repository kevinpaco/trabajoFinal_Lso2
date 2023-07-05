package ar.contacto.listener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

import ar.contacto.controller.ContactoController;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRegistration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Configuration
@ServletComponentScan // Escanea y registra los componentes servlets, filters y listeners
public class Listener extends ContextLoaderListener  implements ServletContextListener{
	
	private WebApplicationContext springContext;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // Obtener el contexto de Spring
        springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext());

        // Obtener el bean del controlador
        ContactoController contactoController = springContext.getBean(ContactoController.class);

        // Inicializar las rutas del controlador
        DispatcherServlet dispatcherServlet = springContext.getBean(DispatcherServlet.class);
        ServletRegistration.Dynamic dynamic = servletContextEvent.getServletContext().addServlet("contacto", dispatcherServlet);
        dynamic.addMapping("/contacto/*");
    }

}
