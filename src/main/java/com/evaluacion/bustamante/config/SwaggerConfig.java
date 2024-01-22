package com.evaluacion.bustamante.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * SwaggerConfig.java
 * version 1.0
 * Fecha: 21 de enero de 2024
 * */
@Configuration
public class SwaggerConfig {

    @Value("${evaluacion.openapi.url}")
    private String urlOpenApi;

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl(urlOpenApi);
        server.setDescription("URL API Evaluacion");

        Contact contact = new Contact();
        contact.setEmail("bonfersen@gmail.com");
        contact.setName("Luis Bustamante");

        Info info = new Info()
                .title("API 0.0.1 Mantenimiento Usuario")
                .version("0.0.1")
                .contact(contact)
                .description("Se exponen dos endpoints: Buscar usuario por su ID en UUID y creacion de registro de un usuario con sus telefonos asociados");

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
