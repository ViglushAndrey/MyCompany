package com.example.mycompany.DAO.Rental;

import com.example.mycompany.model.Rental;
import com.example.mycompany.repository.RentalRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;

@Service
public class RentalDAOImpl implements IRentalDao{

    @Autowired
    RentalRep repository;

    @Override
    public Rental create(Rental rental) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        rental.setId(id);

        repository.save(rental);

        return rental;
    }

    @Override
    public Rental update(Rental rental) {

        rental.setId(rental.getId());

        repository.save(rental);

        return rental;
    }
}
