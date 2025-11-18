package com.autonoma.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicioFacturacionApplication {

    public static void main(String[] args) {
        // OJO: Le decimos que corra en el puerto 8081
        // para que no choque con nuestro servicio REST (que usa 8080).
        System.setProperty("server.port", "8081");
        SpringApplication.run(ServicioFacturacionApplication.class, args);
    }

}