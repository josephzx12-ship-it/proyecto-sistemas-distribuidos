package com.autonoma.proyecto.models;

import jakarta.persistence.*; // Importante: usa jakarta, no javax
import lombok.Data; // Lombok para getters, setters, etc.

@Data // Anotación de Lombok: genera getters, setters, toString, etc.
@Entity // Le dice a JPA que esta clase es una tabla en la BD
@Table(name = "usuarios") // El nombre de la tabla será "usuarios"
public class Usuario {

    @Id // Marca esta variable como la Llave Primaria (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    @Column(nullable = false) // Campo no puede ser nulo
    private String nombres;

    @Column(nullable = false, unique = true) // No nulo y debe ser único
    private String email;

    @Column(nullable = false)
    private String password;

}