package com.example.mycompany.DAO.Moto;

import com.example.mycompany.DAO.Auto.IAutoDAO;
import com.example.mycompany.model.Auto;
import com.example.mycompany.model.Moto;
import com.example.mycompany.repository.AutoRepository;
import com.example.mycompany.repository.MotoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoDAOImpl implements IMotoDAO {

    @Autowired
    MotoRep repository;

    @Override
    public Moto create(Moto moto) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        moto.setId(id);

        repository.save(moto);
        return moto;
    }

    @Override
    public Moto update(Moto moto) {

        moto.setId(moto.getId());

        repository.save(moto);
        return moto;
    }

    public Moto findTypeByRegistrationNumber(String registrationNumber){
        return repository.findTypeByRegistrationNumber(registrationNumber).get();
    }
}
