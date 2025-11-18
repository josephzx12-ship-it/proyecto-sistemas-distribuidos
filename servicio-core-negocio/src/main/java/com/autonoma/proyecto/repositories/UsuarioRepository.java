package com.autonoma.proyecto.repositories;

import com.autonoma.proyecto.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //                                  ESTA ES LA PARTE QUE TE FALTA

    // No necesitas escribir NADA MÁS aquí.
    // Al extender JpaRepository, ya nos da:
    // .save()
    // .findAll()
    // .findById()
    // .delete()
    // y mucho más.
}