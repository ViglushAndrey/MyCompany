package com.example.mycompany.DAO.Auto;

import com.example.mycompany.model.Auto;
import org.springframework.stereotype.Service;

@Service
public interface IAutoDAO {

    Auto create (Auto auto);
    Auto update (Auto auto);

}
