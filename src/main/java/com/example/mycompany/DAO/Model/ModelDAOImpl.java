package com.example.mycompany.DAO.Model;

import com.example.mycompany.model.Model;
import com.example.mycompany.repository.ModelRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelDAOImpl implements IModelDAO{

    @Autowired
    ModelRep repository;

    @Override
    public Model create(Model model) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        model.setId(id);

        repository.save(model);
        return model;
    }

    @Override
    public Model update(Model model) {

        model.setId(model.getId());

        repository.save(model);
        return model;
    }
}
