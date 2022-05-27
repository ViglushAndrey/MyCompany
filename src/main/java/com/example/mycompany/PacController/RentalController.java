package com.example.mycompany.PacController;

import com.example.mycompany.DTO.Auto.AutoDTOCreate;
import com.example.mycompany.DTO.Auto.AutoDTOUpdate;
import com.example.mycompany.DTO.Rental.RentalDTOCreate;
import com.example.mycompany.DTO.Rental.RentalDTOUpdate;
import com.example.mycompany.model.Rental;
import com.example.mycompany.repository.RentalRep;
import com.example.mycompany.service.rental.RentalServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rentals")
@RequiredArgsConstructor
public class RentalController {

    @Autowired
    RentalRep rentalRep;

    private final RentalServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Rental> getAll(){
        return rentalRep.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Rental getById(@PathVariable Long id){
        return rentalRep.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Rental> deleteById(@PathVariable Long id){

        rentalRep.deleteById(id);

        return rentalRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Rental create(@RequestBody Rental rental){

        return service.create(rental);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Rental update(@RequestBody Rental rental){

        return service.update(rental);
    }

    @Operation(summary = " DTO Rental creation",
            description = " Adds new object to the Rental list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Rental createDTO(@RequestBody RentalDTOCreate rental){

        return service.createDTO(rental);
    }

    @Operation(summary = " DTO Rental updating",
            description = " Updates Rental with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Rental updateDTO(@RequestBody RentalDTOUpdate rental){

        return service.updateDTO(rental);
    }

}
