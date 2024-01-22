package com.evaluacion.bustamante.api.service;

import com.evaluacion.bustamante.api.domain.Notificacion;
import com.evaluacion.bustamante.api.domain.UsuarioInfo;
import com.evaluacion.bustamante.api.domain.UsuarioResponse;
import com.evaluacion.bustamante.api.entity.Usuario;

/**
 * UsuarioService.java
 * version 1.0
 * Fecha: 21 de enero de 2024
 * */
public interface UsuarioService {

    Usuario findUsuarioByUseruuid(String id);

    UsuarioResponse saveUsuario(UsuarioInfo usuarioInfo) throws Exception;
}
