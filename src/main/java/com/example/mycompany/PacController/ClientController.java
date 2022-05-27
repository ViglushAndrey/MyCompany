package com.example.mycompany.PacController;

import com.example.mycompany.DTO.Auto.AutoDTOCreate;
import com.example.mycompany.DTO.Auto.AutoDTOUpdate;
import com.example.mycompany.DTO.Client.ClientDTOCreate;
import com.example.mycompany.DTO.Client.ClientDTOUpdate;
import com.example.mycompany.model.Auto;
import com.example.mycompany.model.Client;
import com.example.mycompany.repository.*;
import com.example.mycompany.service.client.ClientServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    MotoRep motoRep;

    @Autowired
    RentalRep rentalRep;

    @Autowired
    SalesRep salesRep;

    @Autowired
    ClientRep clientRep;

    private final ClientServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Client> getAll(){
        return clientRep.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Client getById(@PathVariable Long id){
        return clientRep.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Client> deleteById(@PathVariable Long id){

        clientRep.deleteById(id);

        return clientRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Client create(@RequestBody Client client){

        return service.create(client);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Client update(@RequestBody Client client){

        return service.update(client);
    }

    @Operation(summary = " DTO Client creation",
            description = " Adds new object to the Client list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Client createDTO(@RequestBody ClientDTOCreate client){

        return service.createDTO(client);
    }

    @Operation(summary = " DTO Client updating",
            description = " Updates Client with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Client updateDTO(@RequestBody ClientDTOUpdate client){

        return service.updateDTO(client);
    }
}
