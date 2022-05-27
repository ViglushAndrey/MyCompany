package com.example.mycompany.PacController;

import com.example.mycompany.DTO.Model.ModelDTOCreate;
import com.example.mycompany.DTO.Model.ModelDTOUpdate;
import com.example.mycompany.model.Model;
import com.example.mycompany.repository.AutoRepository;
import com.example.mycompany.repository.ModelRep;
import com.example.mycompany.service.model.ModelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/models")
@RequiredArgsConstructor
public class ModelController {

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    ModelRep modelRep;

    private final ModelServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Model> getAll(){
        return modelRep.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Model getById(@PathVariable Long id){
        return modelRep.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Model> deleteById(@PathVariable Long id){

        modelRep.deleteById(id);

        return modelRep.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Model create(@RequestBody Model model){

        return service.create(model);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Model update(@RequestBody Model model){

        return service.update(model);
    }

    @Operation(summary = " DTO Model creation",
            description = " Adds new object to the Model list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Model createDTO(@RequestBody ModelDTOCreate model){

        return service.createDTO(model);
    }

    @Operation(summary = " DTO Model updating",
            description = " Updates Model with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Model updateDTO(@RequestBody ModelDTOUpdate model){

        return service.updateDTO(model);
    }


}
