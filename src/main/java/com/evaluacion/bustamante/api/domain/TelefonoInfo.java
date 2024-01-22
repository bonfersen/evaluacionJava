package com.evaluacion.bustamante.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TelefonoInfo.java
 * version 1.0
 * Fecha: 21 de enero de 2024
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelefonoInfo {
    private String number;
    private String citycode;
    private String contrycode;
}
