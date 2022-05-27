package com.example.mycompany.DAO.Sales;

import com.example.mycompany.model.Sales;
import com.example.mycompany.repository.SalesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesDAOImpl implements ISalesDAO{

    @Autowired
    SalesRep repository;

    @Override
    public Sales create(Sales sales) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        sales.setId(id);

        repository.save(sales);

        return sales;
    }

    @Override
    public Sales update(Sales sales) {

        sales.setId(sales.getId());

        repository.save(sales);

        return sales;
    }
}
