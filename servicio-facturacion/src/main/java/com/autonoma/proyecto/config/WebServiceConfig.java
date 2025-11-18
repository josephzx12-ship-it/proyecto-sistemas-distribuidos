package com.autonoma.proyecto.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs // ¡Importante! Habilita los Web Services SOAP
@Configuration // Le dice a Spring que esto es una clase de configuración
public class WebServiceConfig extends WsConfigurerAdapter {

    // 1. Configura el servlet que recibirá las peticiones SOAP
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*"); // Escuchará en /ws/*
    }

    // 2. Define el WSDL basado en nuestro XSD
    // El nombre "facturas" será la URL del WSDL
    @Bean(name = "facturas")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition wsdlDefinition = new DefaultWsdl11Definition();
        wsdlDefinition.setPortTypeName("FacturasPort");
        wsdlDefinition.setLocationUri("/ws");
        // El namespace debe ser el mismo que pusimos en el .xsd
        wsdlDefinition.setTargetNamespace("http://www.autonoma.com/proyecto/facturas");
        wsdlDefinition.setSchema(schema);
        return wsdlDefinition;
    }

    // 3. Le dice a Spring dónde está nuestro archivo .xsd
    @Bean
    public XsdSchema facturasSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/factura.xsd"));
    }
}