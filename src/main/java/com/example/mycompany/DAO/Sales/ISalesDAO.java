package com.example.mycompany.DAO.Sales;

import com.example.mycompany.model.Rental;
import com.example.mycompany.model.Sales;
import org.springframework.stereotype.Service;

@Service
public interface ISalesDAO {

    Sales create (Sales sales);
    Sales update (Sales sales);

}
