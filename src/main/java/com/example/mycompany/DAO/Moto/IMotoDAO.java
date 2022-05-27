package com.example.mycompany.DAO.Moto;

import com.example.mycompany.model.Auto;
import com.example.mycompany.model.Moto;
import org.springframework.stereotype.Service;

@Service
public interface IMotoDAO {

    Moto create (Moto moto);
    Moto update (Moto moto);

}
