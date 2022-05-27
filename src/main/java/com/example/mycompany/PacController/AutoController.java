package com.example.mycompany.PacController;

import com.example.mycompany.DTO.Auto.AutoDTOCreate;
import com.example.mycompany.DTO.Auto.AutoDTOUpdate;
import com.example.mycompany.model.Auto;
import com.example.mycompany.repository.AutoRepository;
import com.example.mycompany.repository.RentalRep;
import com.example.mycompany.repository.SalesRep;
import com.example.mycompany.service.auto.AutoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/auto")

public class AutoController {

    @Autowired
    RentalRep rentalRep;

    @Autowired
    SalesRep salesRep;

    @Autowired
    AutoServiceImpl service;

    @Autowired
    AutoRepository autoRepository;



    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Auto> getAll(){
        return autoRepository.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Auto getById(@PathVariable Long id){
        return autoRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Auto> deleteById(@PathVariable Long id){

        autoRepository.deleteById(id);

        return autoRepository.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Auto create(@RequestBody Auto auto){

        return service.create(auto);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Auto update(@RequestBody Auto auto){

        return service.update(auto);
    }

   @Operation(summary = " DTO Mark creation",
            description = " Adds new object to the Mark list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
   @PreAuthorize("hasRole('ADMIN')")
    public Auto createDTO(@RequestBody AutoDTOCreate auto){

        return service.createDTO(auto);
    }

 /*   @Operation(summary = " DTO Auto creation",
            description = " Adds new object to the Auto list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    public Auto createDTO2(@RequestBody AutoRequest auto){

        return service.createDTO(auto);
    }*/

    @Operation(summary = " DTO Auto updating",
            description = " Updates Auto with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Auto updateDTO(@RequestBody AutoDTOUpdate auto){

        return service.updateDTO(auto);
    }
}
