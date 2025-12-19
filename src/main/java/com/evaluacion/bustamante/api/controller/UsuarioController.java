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
    public ResponseEntity saveUsuario(@RequestBody UsuarioInfo usuarioInfo) {
        try {
            return new ResponseEntity(usuarioService.saveUsuario(usuarioInfo), HttpStatus.CREATED);
        } catch (Exception e) {
            Notificacion notificacion = new Notificacion();
            notificacion.setMensaje(e.getMessage());
            return new ResponseEntity(notificacion, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Metodo para listar todos los usuarios registrados en hsqldb
     * */
    @GetMapping("/all")
    public ResponseEntity listAllUsuarios() {
        try {
            //return new ResponseEntity(usuarioService.findAllUsuarios(), HttpStatus.OK);
            return null;
        } catch (Exception e) {
            Notificacion notificacion = new Notificacion();
            notificacion.setMensaje(e.getMessage());
            return new ResponseEntity(notificacion, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
