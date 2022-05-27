package com.example.mycompany.DAO.Rental;

import com.example.mycompany.model.Moto;
import com.example.mycompany.model.Rental;
import org.springframework.stereotype.Service;

@Service
public interface IRentalDao {

    Rental create (Rental rental);
    Rental update (Rental rental);

}
