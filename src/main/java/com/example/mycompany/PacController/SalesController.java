package com.example.mycompany.PacController;

import com.example.mycompany.DTO.Sales.SalesDTOCreate;
import com.example.mycompany.DTO.Sales.SalesDTOUpdate;
import com.example.mycompany.model.Sales;
import com.example.mycompany.repository.SalesRep;
import com.example.mycompany.service.sales.SalesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/sales")
@RequiredArgsConstructor
public class SalesController {

    @Autowired
    SalesRep salesRep;

    private final SalesServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Sales> getAll(){
        return salesRep.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Sales getById(@PathVariable Long id){
        return salesRep.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Sales> deleteById(@PathVariable Long id){

        salesRep.deleteById(id);

        return salesRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Sales create(@RequestBody Sales sales){

        return service.create(sales);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Sales update(@RequestBody Sales sales){

        return service.update(sales);
    }

    @Operation(summary = " DTO Sales creation",
            description = " Adds new object to the Sales list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Sales createDTO(@RequestBody SalesDTOCreate rental){

        return service.createDTO(rental);
    }

    @Operation(summary = " DTO Sales updating",
            description = " Updates Sales with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Sales updateDTO(@RequestBody SalesDTOUpdate rental){

        return service.updateDTO(rental);
    }

}
