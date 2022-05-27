package com.example.mycompany.service.moto;

import com.example.mycompany.DAO.Moto.MotoDAOImpl;
import com.example.mycompany.DTO.Auto.AutoRequest;
import com.example.mycompany.DTO.Moto.MotoDTOCreate;
import com.example.mycompany.DTO.Moto.MotoDTOUpdate;
import com.example.mycompany.model.*;
import com.example.mycompany.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.HashSet;
import java.util.Random;

@Service

public class MotoServiceImpl implements IMotoService{

    @Autowired
    MotoDAOImpl dao;

    @Autowired
    RentalRep rentalRep;

    @Autowired
    SalesRep salesRep;

    @Autowired
    ModelRep modelRep;

    @Autowired
     MotoRep repository;

    public Page<Moto> getAll(Integer page, Integer size){
        var pageble = PageRequest.of(page, size);
        return repository.findAll(pageble);
    }

    public Moto createDTO(MotoDTOCreate request) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var moto = Moto.builder()
                .id(id)
                .registrationNumber(request.getRegistrationNumber())
                .fuelType(request.getFuelType())
                .numberOfSeats(request.getNumberOfSeats())
                .bodyColor(request.getBodyColor())
                .bodyType(request.getBodyType())
                .yearOfTheMoto(request.getYearOfTheMoto())
                .motoModel(modelRep.findById(request.getMotoModel()).get())
                .build();

        return repository.save(moto);

    }

    public Moto updateDTO(MotoDTOUpdate request) {

        var moto = Moto.builder()
                .id(repository.findById(request.getId()).get().getId())
                .registrationNumber(request.getRegistrationNumber())
                .fuelType(request.getFuelType())
                .numberOfSeats(request.getNumberOfSeats())
                .bodyColor(request.getBodyColor())
                .bodyType(request.getBodyType())
                .yearOfTheMoto(request.getYearOfTheMoto())
                .motoModel(modelRep.findById(request.getMotoModel()).get())
                .build();

        return repository.save(moto);

    }

    @Override
    public Moto create(Moto moto) {
        return dao.create(moto);
    }

    @Override
    public Moto update(Moto moto) {
        return dao.update(moto);
    }
}
