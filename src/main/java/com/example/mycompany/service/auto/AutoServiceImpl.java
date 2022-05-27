package com.example.mycompany.service.auto;

import com.example.mycompany.DAO.Auto.AutoDAOImpl;
import com.example.mycompany.DTO.Auto.AutoDTOCreate;
import com.example.mycompany.DTO.Auto.AutoDTOUpdate;
import com.example.mycompany.DTO.Auto.AutoRequest;
import com.example.mycompany.DTO.Mark.MarkDTOUpdate;
import com.example.mycompany.model.*;
import com.example.mycompany.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements IAutoService{

    @Autowired
    AutoDAOImpl dao;

    @Autowired
    RentalRep rentalRep;

    @Autowired
    SalesRep salesRep;

    @Autowired
    ModelRep modelRep;

    private final AutoRepository repository;

    public Page<Auto> getAll(Integer page, Integer size) {
        var pageble = PageRequest.of(page, size);
        return repository.findAll(pageble);
    }



    public Auto createDTO(AutoDTOCreate request) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var auto = Auto.builder()
                .id(id)
                .registrationNumber(request.getRegistrationNumber())
                .fuelType(request.getFuelType())
                .numberOfSeats(request.getNumberOfSeats())
                .numberOfDoors(request.getNumberOfDoors())
                .bodyColor(request.getBodyColor())
                .bodyType(request.getBodyType())
                .yearOfTheCar(request.getYearOfTheCar())
                .carModel(modelRep.findById(request.getCarModel()).get())
                .build();

        return repository.save(auto);
    }

    public Auto updateDTO(AutoDTOUpdate request) {

        var auto = Auto.builder()
                .id(repository.findById(request.getId()).get().getId())
                .registrationNumber(request.getRegistrationNumber())
                .fuelType(request.getFuelType())
                .numberOfSeats(request.getNumberOfSeats())
                .numberOfDoors(request.getNumberOfDoors())
                .bodyColor(request.getBodyColor())
                .bodyType(request.getBodyType())
                .yearOfTheCar(request.getYearOfTheCar())
                .carModel(modelRep.findById(request.getCarModel()).get())
                .build();

        return repository.save(auto);
    }

    @Override
    public Auto create(Auto auto) {
        return dao.create(auto);
    }

    @Override
    public Auto update(Auto auto) {
        return dao.update(auto);
    }



/*
    public Auto createDTO(AutoRequest request) {
        var auto = Auto.builder()
                .id(new Random().nextLong())
                .registrationNumber(request.getRegistrationNumber())
                .fuelType(request.getFuelType())
                .numberOfSeats(request.getNumberOfSeats())
                .numberOfDoors(request.getNumberOfDoors())
                .bodyColor(request.getBodyColor())
                .bodyType(request.getBodyType())
                .yearOfTheCar(request.getYearOfTheCar())
                .carMark(new HashSet<>())
                .carModel(new HashSet<>())
                .clients(new Client())
                .collaborator(new Collaborator())
                .rental(new Rental())
                .sales(new Sales())
                .build();

        return repository.save(auto);
    }
*/
}
