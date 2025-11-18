package com.autonoma.proyecto.controllers;

import com.autonoma.proyecto.models.Usuario;
import com.autonoma.proyecto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Le dice a Spring que esto es un controlador REST
@RequestMapping("/usuarios") // Pone /usuarios como prefijo para todas las rutas de esta clase
public class UsuarioController {

    // 1. Inyectar el Repositorio
    // Spring mágicamente nos da una instancia de UsuarioRepository
    @Autowired
    private UsuarioRepository usuarioRepository; // <-- Variable de instancia

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) { // <-- ¡Correcto! Es un método de instancia

        // ...
        Usuario usuarioGuardado = usuarioRepository.save(usuario); // <-- Ahora sí funciona

        return usuarioGuardado;
    }

    // (Opcional) Un endpoint para ver todos los usuarios
    @GetMapping("/todos")
    public Iterable<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }
}