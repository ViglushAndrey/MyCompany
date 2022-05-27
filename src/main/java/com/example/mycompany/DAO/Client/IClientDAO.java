package com.example.mycompany.DAO.Client;

import com.example.mycompany.model.Auto;
import com.example.mycompany.model.Client;
import org.springframework.stereotype.Service;

@Service
public interface IClientDAO {

    Client create (Client client);
    Client update (Client client);

}
