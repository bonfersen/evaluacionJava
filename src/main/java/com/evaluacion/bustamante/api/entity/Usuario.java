package com.evaluacion.bustamante.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Usuario.java
 * version 1.0
 * Fecha: 21 de enero de 2024
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    private String useruuid;

    private String name;

    private String mail;

    private String password;

    private Date created;

    private Date modified;

    private Date lastlogin;

    private String isactive;

    @JsonIgnoreProperties("usuarioTelefono")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioTelefono", cascade = CascadeType.ALL)
    private List<Telefono> telefonos = new ArrayList<>();
}
