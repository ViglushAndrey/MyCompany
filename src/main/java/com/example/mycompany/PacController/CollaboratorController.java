package com.example.mycompany.PacController;

import com.example.mycompany.DTO.Client.ClientDTOCreate;
import com.example.mycompany.DTO.Client.ClientDTOUpdate;
import com.example.mycompany.DTO.Collaborator.CollaboratorDTOCreate;
import com.example.mycompany.DTO.Collaborator.CollaboratorDTOUpdate;
import com.example.mycompany.model.Client;
import com.example.mycompany.model.Collaborator;
import com.example.mycompany.repository.*;
import com.example.mycompany.service.collaborator.CollaboratorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
@RequestMapping("/v1/сollaborators")
@RequiredArgsConstructor
public class CollaboratorController {

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    MotoRep motoRep;

    @Autowired
    RentalRep rentalRep;

    @Autowired
    SalesRep salesRep;

    @Autowired
    CollaboratorRep collaboratorRep;

    private final CollaboratorService service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Collaborator> getAll(){
        return collaboratorRep.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Collaborator getById(@PathVariable Long id){
        return collaboratorRep.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Collaborator> deleteById(@PathVariable Long id){

        collaboratorRep.deleteById(id);

        return collaboratorRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Collaborator create(@RequestBody Collaborator collaborator){

        return service.create(collaborator);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Collaborator update(@RequestBody Collaborator collaborator){

        return service.update(collaborator);
    }

    @Operation(summary = " DTO Collaborator creation",
            description = " Adds new object to the Collaborator list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Collaborator createDTO(@RequestBody CollaboratorDTOCreate collaborator){

        return service.createDTO(collaborator);
    }

    @Operation(summary = " DTO Collaborator updating",
            description = " Updates Collaborator with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Collaborator updateDTO(@RequestBody CollaboratorDTOUpdate collaborator){

        return service.updateDTO(collaborator);
    }

}
