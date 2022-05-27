package com.example.mycompany.service.collaborator;

import com.example.mycompany.DAO.Collaborator.CollaboratorDAOImpl;
import com.example.mycompany.DTO.Collaborator.CollaboratorDTOCreate;
import com.example.mycompany.DTO.Collaborator.CollaboratorDTOUpdate;
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
public class CollaboratorService implements ICollabratorService{

    @Autowired
    CollaboratorDAOImpl dao;

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    MotoRep motoRep;

    @Autowired
    RentalRep rentalRep;

    @Autowired
    SalesRep salesRep;


    private final CollaboratorRep repository;

    public Page<Collaborator> getAll(Integer page, Integer size){
        var pageble = PageRequest.of(page, size);
        return repository.findAll(pageble);
    }

    public Collaborator createDTO(CollaboratorDTOCreate request) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var сollaborator = Collaborator.builder()
                .id(id)
                .name(request.getName())
                .position(request.getPosition())
                .tel(request.getTel())
                .build();

        return repository.save(сollaborator);
    }


    public Collaborator updateDTO(CollaboratorDTOUpdate request) {

        var сollaborator = Collaborator.builder()
                .id(repository.findById(request.getId()).get().getId())
                .name(request.getName())
                .position(request.getPosition())
                .tel(request.getTel())
                .build();

        return repository.save(сollaborator);

    }

    @Override
    public Collaborator create(Collaborator collaborator) {
        return dao.create(collaborator);
    }

    @Override
    public Collaborator update(Collaborator collaborator) {
        return dao.update(collaborator);
    }
}
