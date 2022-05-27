package com.example.mycompany.PacController;

import com.example.mycompany.DTO.Auto.AutoDTOCreate;
import com.example.mycompany.DTO.Auto.AutoDTOUpdate;
import com.example.mycompany.DTO.Moto.MotoDTOCreate;
import com.example.mycompany.DTO.Moto.MotoDTOUpdate;
import com.example.mycompany.model.Auto;
import com.example.mycompany.model.Moto;
import com.example.mycompany.repository.AutoRepository;
import com.example.mycompany.repository.MotoRep;
import com.example.mycompany.repository.RentalRep;
import com.example.mycompany.repository.SalesRep;
import com.example.mycompany.service.moto.MotoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/moto")

public class MotoCotroller {

    @Autowired
    RentalRep rentalRep;

    @Autowired
    SalesRep salesRep;

    @Autowired
    MotoServiceImpl service;

    @Autowired
    MotoRep motoRep;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Moto> getAll(){
        return motoRep.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Moto getById(@PathVariable Long id){
        return motoRep.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Moto> deleteById(@PathVariable Long id){

        motoRep.deleteById(id);

        return motoRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Moto create(@RequestBody Moto moto){

        return service.create(moto);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Moto update(@RequestBody Moto moto){

        return service.update(moto);
    }

    @Operation(summary = " DTO Moto creation",
            description = " Adds new object to the Moto list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Moto createDTO(@RequestBody MotoDTOCreate moto){

        return service.createDTO(moto);
    }

    @Operation(summary = " DTO Moto updating",
            description = " Updates Moto with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Moto updateDTO(@RequestBody MotoDTOUpdate moto){

        return service.updateDTO(moto);
    }


}
