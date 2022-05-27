package com.example.mycompany.controller;


import com.example.mycompany.DTO.Auto.AutoDTOCreate;
import com.example.mycompany.DTO.Auto.AutoDTOUpdate;
import com.example.mycompany.DTO.Model.ModelDTOCreate;
import com.example.mycompany.DTO.Model.ModelDTOUpdate;
import com.example.mycompany.model.Auto;
import com.example.mycompany.model.Model;
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
public class AutoControllerTest {

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

        var auto = Auto.builder()
                .registrationNumber("1111wdfwfafaf")
                .fuelType("disel")
                .numberOfSeats("5")
                .numberOfDoors("4")
                .bodyColor("red")
                .bodyType("sedan")
                .yearOfTheCar("2018")
                .carModel(modelRep.findById(1L).get())
                .rental(new HashSet<>())
                .sales(new HashSet<>())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(auto);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/auto/create")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


    @Test
    @Order(2)
    @WithMockUser(roles = "USER")
    void getAuto() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/auto/get/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());

    }

    @Test
    @Order(3)
    @WithMockUser(roles = "ADMIN")
    void createDTOAuto() throws Exception {
        AutoDTOCreate dtoCreate = new AutoDTOCreate();
        dtoCreate.setRegistrationNumber("1111wdfwfafaf");
        dtoCreate.setFuelType("disel");
        dtoCreate.setNumberOfSeats("5");
        dtoCreate.setNumberOfDoors("4");
        dtoCreate.setBodyColor("red");
        dtoCreate.setBodyType("pasat");
        dtoCreate.setYearOfTheCar("2018");
        dtoCreate.setCarModel(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoCreate);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/auto/createDTO")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @Order(4)
    @WithMockUser(roles = "ADMIN")
    void updateDTOAuto() throws Exception {
        AutoDTOUpdate dtoUpdate = new AutoDTOUpdate();
        dtoUpdate.setId(1L);
        dtoUpdate.setRegistrationNumber("1111wdfwfafaf");
        dtoUpdate.setFuelType("disel");
        dtoUpdate.setNumberOfSeats("5");
        dtoUpdate.setNumberOfDoors("4");
        dtoUpdate.setBodyColor("red");
        dtoUpdate.setBodyType("pasat");
        dtoUpdate.setYearOfTheCar("2018");
        dtoUpdate.setCarModel(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoUpdate);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/auto/updateDTO")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @Order(5)
    @WithMockUser(roles = "ADMIN")
    void deleteById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/auto/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @Order(6)
    @WithMockUser(roles = "USER")
    void getById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/auto/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @Order(6)
    @WithMockUser(roles = "ADMIN")
    void update() throws Exception{

        var auto = Auto.builder()
                .id(1L)
                .registrationNumber("1111wdfwfafaf")
                .fuelType("disel")
                .numberOfSeats("5")
                .numberOfDoors("4")
                .bodyColor("black")
                .bodyType("pasat")
                .yearOfTheCar("2018")
                .carModel(modelRep.findById(1L).get())
                .rental(new HashSet<>())
                .sales(new HashSet<>())
                .build();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(auto);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/auto/update")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }
}
