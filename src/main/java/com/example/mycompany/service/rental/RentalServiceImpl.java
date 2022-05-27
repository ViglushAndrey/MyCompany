package com.example.mycompany.service.rental;

import com.example.mycompany.DAO.Rental.RentalDAOImpl;
import com.example.mycompany.DTO.Rental.RentalDTOCreate;
import com.example.mycompany.DTO.Rental.RentalDTOUpdate;
import com.example.mycompany.model.Rental;
import com.example.mycompany.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RentalServiceImpl implements IRentalService{

    @Autowired
    RentalDAOImpl dao;

    @Autowired
    ClientRep clientRep;

    @Autowired
    CollaboratorRep collaboratorRep;

    @Autowired
    RentalRep repository;

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    MotoRep motoRep;

    public Page<Rental> getAll(Integer page, Integer size){
        var pageble = PageRequest.of(page, size);
        return repository.findAll(pageble);
    }

    public Rental createDTO(RentalDTOCreate request) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var rental = Rental.builder()
                .id(id)
                .auto(autoRepository.findById(request.getAuto()).get())
                .moto(motoRep.findById(request.getMoto()).get())
                .clients(clientRep.findById(request.getClients()).get())
                .collaborators(collaboratorRep.findById(request.getCollaborators()).get())
                .rentalStartDate(request.getRentalStartDate())
                .numberOfRentalDays(request.getNumberOfRentalDays())
                .build();

        return repository.save(rental);
    }

    public Rental updateDTO(RentalDTOUpdate request) {

        var rental = Rental.builder()
                .id(repository.findById(request.getId()).get().getId())
                .auto(autoRepository.findById(request.getAuto()).get())
                .moto(motoRep.findById(request.getMoto()).get())
                .clients(clientRep.findById(request.getClients()).get())
                .collaborators(collaboratorRep.findById(request.getCollaborators()).get())
                .rentalStartDate(request.getRentalStartDate())
                .numberOfRentalDays(request.getNumberOfRentalDays())
                .build();

        return repository.save(rental);
    }

    @Override
    public Rental create(Rental rental) {
        return dao.create(rental);
    }

    @Override
    public Rental update(Rental rental) {
        return dao.update(rental);
    }
}
