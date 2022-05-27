package com.example.mycompany.controller;

import com.example.mycompany.DTO.Auto.AutoDTOCreate;
import com.example.mycompany.DTO.Model.ModelDTOUpdate;
import com.example.mycompany.DTO.Moto.MotoDTOCreate;
import com.example.mycompany.DTO.Moto.MotoDTOUpdate;
import com.example.mycompany.model.Auto;
import com.example.mycompany.model.Moto;
import com.example.mycompany.repository.ModelRep;
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
public class MotoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ModelRep modelRep;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));


    @Test
    @Order(1)
    @WithMockUser(roles = "ADMIN")
    void create() throws Exception{

        var moto = Moto.builder()
                .registrationNumber("1111wdfwfafaf")
                .fuelType("disel")
                .numberOfSeats("5")
                .bodyColor("red")
                .bodyType("sedan")
                .yearOfTheMoto("2018")
                .motoModel(modelRep.findById(1L).get())
                .rental(new HashSet<>())
                .sales(new HashSet<>())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(moto);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/moto/create")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


    @Test
    @Order(2)
    @WithMockUser(roles = "USER")
    void getMoto() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/moto/get/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());

    }

    @Test
    @Order(3)
    @WithMockUser(roles = "ADMIN")
    void createDTOMoto() throws Exception {
        MotoDTOCreate dtoCreate = new MotoDTOCreate();
        dtoCreate.setRegistrationNumber("1111wdfwfafaf");
        dtoCreate.setFuelType("disel");
        dtoCreate.setNumberOfSeats("2");
        dtoCreate.setBodyColor("red");
        dtoCreate.setBodyType("grsegeg");
        dtoCreate.setYearOfTheMoto("2018");
        dtoCreate.setMotoModel(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoCreate);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/moto/createDTO")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @Order(4)
    @WithMockUser(roles = "ADMIN")
    void updateDTOMoto() throws Exception {
        MotoDTOUpdate dtoUpdate = new MotoDTOUpdate();
        dtoUpdate.setId(1L);
        dtoUpdate.setRegistrationNumber("1111wdfwfafaf");
        dtoUpdate.setFuelType("disel");
        dtoUpdate.setNumberOfSeats("1");
        dtoUpdate.setBodyColor("red");
        dtoUpdate.setBodyType("grsegeg");
        dtoUpdate.setYearOfTheMoto("2018");
        dtoUpdate.setMotoModel(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoUpdate);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/moto/updateDTO")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @Order(5)
    @WithMockUser(roles = "ADMIN")
    void deleteById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/moto/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @Order(6)
    @WithMockUser(roles = "USER")
    void getById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/moto/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @Order(6)
    @WithMockUser(roles = "ADMIN")
    void update() throws Exception{

        var moto = Moto.builder()
                .id(1L)
                .registrationNumber("1111wdfwfafaf")
                .fuelType("disel")
                .numberOfSeats("5")
                .bodyColor("red")
                .bodyType("sedan")
                .yearOfTheMoto("2018")
                .motoModel(modelRep.findById(1L).get())
                .rental(new HashSet<>())
                .sales(new HashSet<>())
                .build();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(moto);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/moto/update")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

}
