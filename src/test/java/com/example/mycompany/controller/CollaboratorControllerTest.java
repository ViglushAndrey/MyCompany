package com.example.mycompany.controller;

import com.example.mycompany.DTO.Client.ClientDTOCreate;
import com.example.mycompany.DTO.Client.ClientDTOUpdate;
import com.example.mycompany.DTO.Collaborator.CollaboratorDTOCreate;
import com.example.mycompany.DTO.Collaborator.CollaboratorDTOUpdate;
import com.example.mycompany.model.Client;
import com.example.mycompany.model.Collaborator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.HashSet;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CollaboratorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Test
    @Order(1)
    @WithMockUser(roles = "ADMIN")
    void create() throws Exception{

        var сollaborators = Collaborator.builder()
                .name("Andrey")
                .position("Manager")
                .tel("0956453242")
                .rental(new HashSet<>())
                .sale(new HashSet<>())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(сollaborators);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/сollaborators/create")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


    @Test
    @Order(2)
    @WithMockUser(roles = "USER")
    void getCollaborators() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/сollaborators/get/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());

    }

    @Test
    @Order(3)
    @WithMockUser(roles = "ADMIN")
    void createDTOCollaborator() throws Exception {
        CollaboratorDTOCreate dtoCreate = new CollaboratorDTOCreate();
        dtoCreate.setName("Andrey");
        dtoCreate.setPosition("manager");
        dtoCreate.setTel("0956453242");


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoCreate);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/сollaborators/createDTO")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @Order(4)
    @WithMockUser(roles = "ADMIN")
    void updateDTOCollaborator() throws Exception {
        CollaboratorDTOUpdate dtoUpdate = new CollaboratorDTOUpdate();
        dtoUpdate.setId(1L);
        dtoUpdate.setName("Katya");
        dtoUpdate.setPosition("manager");
        dtoUpdate.setTel("0956453242");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoUpdate);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/сollaborators/updateDTO")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @Order(5)
    @WithMockUser(roles = "ADMIN")
    void deleteById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/сollaborators/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @Order(6)
    @WithMockUser(roles = "USER")
    void getById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/сollaborators/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @Order(6)
    @WithMockUser(roles = "ADMIN")
    void update() throws Exception{

        var сollaborators = Collaborator.builder()
                .id(1L)
                .name("Andrey")
                .position("Manager")
                .tel("0956453242")
                .rental(new HashSet<>())
                .sale(new HashSet<>())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(сollaborators);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/сollaborators/update")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

}
