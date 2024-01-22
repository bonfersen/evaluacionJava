package com.evaluacion.bustamante.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
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

    @Value("${evaluacion.openapi.dev-url}")
    private String devUrl;

    @Value("${evaluacion.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL entorno de desarrollo");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL entorno de produccion");

        Contact contact = new Contact();
        contact.setEmail("bonfersen@gmail.com");
        contact.setName("Luis");
        contact.setUrl("https://www.linkedin.com/in/luisbustamantevillar/");

        License mitLicense = new License().name("TEST License").url("http://test.com");

        Info info = new Info()
                .title("Tutorial Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.bezkoder.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));

    }
}
