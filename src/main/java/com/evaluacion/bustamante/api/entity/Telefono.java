package com.evaluacion.bustamante.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Telefono.java
 * version 1.0
 * Fecha: 21 de enero de 2024
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Telefono {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idtelefono;
    private String number;
    private String citycode;
    private String contrycode;

    @ManyToOne
    @JoinColumn(name="useruuid")
    private Usuario usuarioTelefono;
}
