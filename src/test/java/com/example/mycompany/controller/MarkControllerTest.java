package com.example.mycompany.controller;

import com.example.mycompany.DTO.Mark.MarkDTOCreate;
import com.example.mycompany.DTO.Mark.MarkDTOUpdate;
import com.example.mycompany.model.Mark;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.containsString;

import java.nio.charset.Charset;
import java.util.HashSet;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MarkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));


    @Test
    @Order(1)
    @WithMockUser(roles = "ADMIN")
    void create() throws Exception{


        var mark = Mark.builder()
                .id(7L)
                .transportmark("M 1000 RR")
                .model(new HashSet<>())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(mark);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/marks/create")
                .content(objectMapper.writeValueAsString(mark)))
                .andExpect(MockMvcResultMatchers.status().isOk());



    }


    @Test
    @Order(2)
    @WithMockUser(roles = "USER")
    void getMarks() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/marks/get/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());

    }

    @Test
    @Order(3)
    @WithMockUser(roles = "ADMIN")
    void createDTOMarks() throws Exception {
        MarkDTOCreate dtoCreate = new MarkDTOCreate();
        dtoCreate.setTransportmark("M 1000 RRR");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoCreate);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/marks/createDTO")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @Order(4)
    @WithMockUser(roles = "ADMIN")
    void updateDTOMarks() throws Exception {
        MarkDTOUpdate dtoUpdate = new MarkDTOUpdate();
        dtoUpdate.setId(1L);
        dtoUpdate.setTransportmark("M 1000");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoUpdate);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/marks/updateDTO")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @Order(5)
    @WithMockUser(roles = "ADMIN")
    void deleteById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/marks/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @Order(6)
    @WithMockUser(roles = "USER")
    void getById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/marks/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @Order(6)
    @WithMockUser(roles = "ADMIN")
    void update() throws Exception{

        var mark = Mark.builder()
                .id(1L)
                .transportmark("M 1000 ")
                .model(new HashSet<>())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(mark);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/marks/update")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }



}
