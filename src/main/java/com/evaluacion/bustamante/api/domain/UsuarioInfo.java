package com.evaluacion.bustamante.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * UsuarioInfo.java
 * version 1.0
 * Fecha: 21 de enero de 2024
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioInfo {
    String name;
    String email;
    String password;
    List<TelefonoInfo> phones;
}
