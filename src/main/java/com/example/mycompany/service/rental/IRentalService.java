package com.example.mycompany.service.rental;

import com.example.mycompany.model.Auto;
import com.example.mycompany.model.Rental;

public interface IRentalService {

    Rental create (Rental rental);
    Rental update (Rental rental);

}
