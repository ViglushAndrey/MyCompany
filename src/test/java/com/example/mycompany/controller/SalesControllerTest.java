package com.example.mycompany.controller;

import com.example.mycompany.DTO.Rental.RentalDTOCreate;
import com.example.mycompany.DTO.Rental.RentalDTOUpdate;
import com.example.mycompany.model.Rental;
import com.example.mycompany.model.Sales;
import com.example.mycompany.repository.AutoRepository;
import com.example.mycompany.repository.ClientRep;
import com.example.mycompany.repository.CollaboratorRep;
import com.example.mycompany.repository.MotoRep;
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
import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SalesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    MotoRep motoRep;

    @Autowired
    ClientRep clientRep;

    @Autowired
    CollaboratorRep collaboratorRep;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));


    @Test
    @Order(1)
    @WithMockUser(roles = "ADMIN")
    void create() throws Exception{

        var sales = Sales.builder()

                .auto(autoRepository.findById(1L).get())
                .moto(motoRep.findById(1L).get())
                .client(clientRep.findById(1L).get())
                .collaborator(collaboratorRep.findById(1L).get())
                .dayOfSale(LocalDate.of(2019,05,25))
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(sales);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/sales/create")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


    @Test
    @Order(2)
    @WithMockUser(roles = "USER")
    void getSales() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/sales/get/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());

    }

    @Test
    @Order(3)
    @WithMockUser(roles = "ADMIN")
    void createDTOSales() throws Exception {
        RentalDTOCreate dtoCreate = new RentalDTOCreate();
        dtoCreate.setAuto(1L);
        dtoCreate.setMoto(1L);
        dtoCreate.setClients(1L);
        dtoCreate.setCollaborators(1L);
        dtoCreate.setNumberOfRentalDays(30L);
        dtoCreate.setRentalStartDate(LocalDate.of(2019,5,25));

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoCreate);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/sales/createDTO")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @Order(4)
    @WithMockUser(roles = "ADMIN")
    void updateDTOSales() throws Exception {
        RentalDTOUpdate dtoUpdate = new RentalDTOUpdate();
        dtoUpdate.setId(1L);
        dtoUpdate.setAuto(1L);
        dtoUpdate.setMoto(1L);
        dtoUpdate.setClients(1L);
        dtoUpdate.setCollaborators(1L);
        dtoUpdate.setNumberOfRentalDays(30L);
        dtoUpdate.setRentalStartDate(LocalDate.of(2019,5,25));


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoUpdate);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/sales/updateDTO")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @Order(5)
    @WithMockUser(roles = "ADMIN")
    void deleteById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/sales/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @Order(6)
    @WithMockUser(roles = "USER")
    void getById() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/sales/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @Order(6)
    @WithMockUser(roles = "ADMIN")
    void update() throws Exception{

        var sales = Sales.builder()
                .id(1L)
                .auto(autoRepository.findById(1L).get())
                .moto(motoRep.findById(1L).get())
                .client(clientRep.findById(1L).get())
                .collaborator(collaboratorRep.findById(1L).get())
                .dayOfSale(LocalDate.of(2019,05,25))
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(sales);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/sales/update")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

}
