package com.autonoma.proyecto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hola")
    public String holaMundo() {
        return "¡El servicio-core-negocio está VIVO!";
    }
}