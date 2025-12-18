package com.evaluacion.bustamante;

import com.evaluacion.bustamante.api.controller.UsuarioController;
import com.evaluacion.bustamante.api.entity.Usuario;
import com.evaluacion.bustamante.api.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void usuarioByIdTest() throws Exception {
        String id = "1";

        mockMvc.perform(get("/api/usuario/find/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void saveUsuarioTest() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setUseruuid(UUID.randomUUID().toString());
        usuario.setName("Eduardo");
        usuario.setMail("eduardo@gmail.com");
        usuario.setPassword("eduardo");
        usuario.setCreated(new Date());
        usuario.setIsactive("1");
        usuario.setLastlogin(new Date());

        mockMvc.perform(post("/api/usuario/save/").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(result -> {
                    int status = result.getResponse().getStatus();
                    org.junit.jupiter.api.Assertions.assertTrue(status == 200 || status == 201,
                            "Unexpected status: " + status);
    })
                .andDo(print());
    }
}
