package com.evaluacion.bustamante.api.service.impl;

import com.evaluacion.bustamante.api.domain.TelefonoInfo;
import com.evaluacion.bustamante.api.domain.UsuarioInfo;
import com.evaluacion.bustamante.api.domain.UsuarioResponse;
import com.evaluacion.bustamante.api.entity.Telefono;
import com.evaluacion.bustamante.api.entity.Usuario;
import com.evaluacion.bustamante.api.repository.TelefonoRepository;
import com.evaluacion.bustamante.api.repository.UsuarioRepository;
import com.evaluacion.bustamante.api.service.UsuarioService;
import com.evaluacion.bustamante.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * UsuarioService.java
 * version 1.0
 * Fecha: 21 de enero de 2024
 * */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    private final UsuarioRepository usuarioRepository;

    private final TelefonoRepository telefonoRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, TelefonoRepository telefonoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.telefonoRepository = telefonoRepository;
    }

    @Override
    public Usuario findUsuarioByUseruuid(String id) {
        return usuarioRepository.findUsuarioByUseruuid(id);
    }

    @Override
    @Transactional
    public UsuarioResponse saveUsuario(UsuarioInfo usuarioInfo) throws Exception {
        UsuarioResponse usuarioResponse = new UsuarioResponse();

        if (!ValidateUtil.isValidFormatEmail(usuarioInfo.getEmail())) {
            throw new Exception("Correo no tiene formato valido");
        }
        if (ValidateUtil.isNotEmpty(usuarioRepository.findUsuarioByMail(usuarioInfo.getEmail()))) {
            throw new Exception("El correo ya esta registrado");
        }
        // Grabar usuario
        Usuario usuario = new Usuario();
        String uuid = UUID.randomUUID().toString();
        log.info("uuid: {}", uuid);
        usuario.setUseruuid(uuid);
        usuario.setName(usuarioInfo.getName());
        usuario.setMail(usuarioInfo.getEmail());
        usuario.setPassword(usuarioInfo.getPassword());
        usuario.setCreated(new Date());
        usuario.setIsactive("1");
        usuario.setLastlogin(new Date());

        List<Telefono> telefonoList = new ArrayList<>();
        // Preparar Telefono
        List<TelefonoInfo> telefonoInfoList = usuarioInfo.getPhones();
        telefonoInfoList.forEach((telefonoInfo) -> {
            Telefono telefono = new Telefono();
            telefono.setNumber(telefonoInfo.getNumber());
            telefono.setCitycode(telefonoInfo.getCitycode());
            telefono.setContrycode(telefonoInfo.getContrycode());
            telefono.setUsuarioTelefono(usuario);
            telefonoList.add(telefono);
        }
        );
        usuario.setTelefonos(telefonoList);
        usuarioRepository.save(usuario);

        usuarioResponse.setUseruuid(usuario.getUseruuid());
        usuarioResponse.setCreated(usuario.getCreated());
        usuarioResponse.setModified(usuario.getModified());
        usuarioResponse.setLastlogin(usuario.getLastlogin());
        usuarioResponse.setToken(usuario.getUseruuid());
        usuarioResponse.setIsactive(usuario.getIsactive());

        return usuarioResponse;
    }
}
