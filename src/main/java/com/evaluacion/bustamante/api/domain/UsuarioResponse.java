package com.evaluacion.bustamante.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * UsuarioResponse.java
 * version 1.0
 * Fecha: 21 de enero de 2024
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private String useruuid;
    private Date created;
    private Date modified;
    private Date lastlogin;
    private String token;
    private String isactive;
}
