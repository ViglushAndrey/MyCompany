package com.example.mycompany.PacController;

import com.example.mycompany.DTO.Mark.MarkDTOCreate;
import com.example.mycompany.DTO.Mark.MarkDTOUpdate;
import com.example.mycompany.model.Mark;
import com.example.mycompany.repository.AutoRepository;
import com.example.mycompany.repository.MarkRepository;
import com.example.mycompany.service.mark.MarkServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("v1/marks")
public class MarkController {

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    MarkRepository markRepository;

    @Autowired
    MarkServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Mark> getAll(){
        return markRepository.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Mark getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Mark> deleteById(@PathVariable Long id){

        markRepository.deleteById(id);

        return markRepository.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Mark create(@RequestBody Mark mark){

        return service.create(mark);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Mark update(@RequestBody Mark mark){

        return service.update(mark);
    }

    @Operation(summary = " DTO Mark creation",
            description = " Adds new object to the Mark list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Mark createDTO(@RequestBody MarkDTOCreate mark){

        return service.createDTO(mark);
    }

    @Operation(summary = " DTO Mark updating",
            description = " Updates Mark with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Mark updateDTO(@RequestBody MarkDTOUpdate mark){

        return service.updateDTO(mark);
    }
}
