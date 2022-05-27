package com.example.mycompany.service.client;


import com.example.mycompany.DAO.Client.ClientDAOImpl;
import com.example.mycompany.DTO.Client.ClientDTOCreate;
import com.example.mycompany.DTO.Client.ClientDTOUpdate;
import com.example.mycompany.model.Client;
import com.example.mycompany.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService{

    @Autowired
    ClientDAOImpl dao;

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    MotoRep motoRep;

    @Autowired
    RentalRep rentalRep;

    @Autowired
    SalesRep salesRep;

    @Autowired
    ClientRep repository;

    public Page<Client> getAll(Integer page, Integer size){
        var pageble = PageRequest.of(page, size);
        return repository.findAll(pageble);
    }



    @Override
    public Client create(Client client) {
        return dao.create(client);
    }

    @Override
    public Client update(Client client) {
        return dao.update(client);
    }

    public Client createDTO(ClientDTOCreate request) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var client = Client.builder()
                .id(id)
                .name(request.getName())
                .address(request.getAddress())
                .tel(request.getTel())
                .build();

        return repository.save(client);
    }

    public Client updateDTO(ClientDTOUpdate request) {

        var client = Client.builder()
                .id(repository.findById(request.getId()).get().getId())
                .name(request.getName())
                .address(request.getAddress())
                .tel(request.getTel())
                .build();

        return repository.save(client);
    }
}
