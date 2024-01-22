package com.evaluacion.bustamante.api.repository;

import com.evaluacion.bustamante.api.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UsuarioRepository.java
 * version 1.0
 * Fecha: 21 de enero de 2024
 * */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Usuario findUsuarioByUseruuid(String user_uuid);

    Usuario findUsuarioByMail(String mail);
}
