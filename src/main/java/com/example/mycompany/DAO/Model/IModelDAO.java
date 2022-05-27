package com.example.mycompany.DAO.Model;

import com.example.mycompany.model.Model;
import org.springframework.stereotype.Service;

@Service
public interface IModelDAO {

    Model create (Model model);
    Model update (Model model);

}
