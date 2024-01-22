package com.evaluacion.bustamante.api.controller;

import com.evaluacion.bustamante.api.domain.Notificacion;
import com.evaluacion.bustamante.api.domain.UsuarioInfo;
import com.evaluacion.bustamante.api.entity.Usuario;
import com.evaluacion.bustamante.api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * SwaggerConfig.java
 * version 1.0
 * Fecha: 21 de enero de 2024
 * */
@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/find/{id}")
    Usuario usuarioById(@PathVariable String id) {
        return usuarioService.findUsuarioByUseruuid(id);
    }

    @PostMapping(value = "/save/")
    public ResponseEntity<Object> saveUsuario(@RequestBody UsuarioInfo usuarioInfo) {
        try {
            return new ResponseEntity<Object>(usuarioService.saveUsuario(usuarioInfo), HttpStatus.OK);
        } catch (Exception e) {
            Notificacion notificacion = new Notificacion();
            notificacion.setMensaje(e.getMessage());
            return new ResponseEntity<Object>(notificacion, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
