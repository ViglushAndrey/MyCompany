package com.example.mycompany.DAO.Auto;

import com.example.mycompany.model.Auto;
import com.example.mycompany.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoDAOImpl implements IAutoDAO {

    @Autowired
    AutoRepository repository;

    @Override
    public Auto create(Auto auto) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        auto.setId(id);

        repository.save(auto);
        return auto;
    }

    @Override
    public Auto update(Auto auto) {

        auto.setId(auto.getId());

        repository.save(auto);
        return auto;
    }

    public Auto findTypeByRegistrationNumber(String registrationNumber){
        return repository.findCarByRegistrationNumber(registrationNumber).get();
    }
}
