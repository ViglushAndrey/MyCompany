package com.example.mycompany.service.sales;

import com.example.mycompany.DAO.Sales.SalesDAOImpl;
import com.example.mycompany.DTO.Sales.SalesDTOCreate;
import com.example.mycompany.DTO.Sales.SalesDTOUpdate;
import com.example.mycompany.model.Sales;
import com.example.mycompany.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceImpl implements ISalesService{

    @Autowired
    ClientRep clientRep;

    @Autowired
    CollaboratorRep collaboratorRep;

    @Autowired
    SalesDAOImpl dao;

    @Autowired
    SalesRep repository;

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    MotoRep motoRep;

    public Page<Sales> getAll(Integer page, Integer size){
        var pageble = PageRequest.of(page, size);
        return repository.findAll(pageble);
    }

    public Sales createDTO(SalesDTOCreate request) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var sales= Sales.builder()
                .id(id)
                .auto(autoRepository.findById(request.getAuto()).get())
                .moto(motoRep.findById(request.getMoto()).get())
                .client(clientRep.findById(request.getClient()).get())
                .collaborator(collaboratorRep.findById(request.getCollaborator()).get())
                .dayOfSale(request.getDayOfSale())
                .build();

        return repository.save(sales);
    }

    public Sales updateDTO(SalesDTOUpdate request) {

        var sales= Sales.builder()
                .auto(autoRepository.findById(request.getAuto()).get())
                .moto(motoRep.findById(request.getMoto()).get())
                .client(clientRep.findById(request.getClient()).get())
                .collaborator(collaboratorRep.findById(request.getCollaborator()).get())
                .dayOfSale(request.getDayOfSale())
                .build();

        return repository.save(sales);
    }

    @Override
    public Sales create(Sales sales) {
        return dao.create(sales);
    }

    @Override
    public Sales update(Sales sales) {
        return dao.update(sales);
    }
}
