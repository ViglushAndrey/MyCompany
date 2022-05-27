package com.example.mycompany.DAO.Client;

import com.example.mycompany.model.Client;
import com.example.mycompany.repository.ClientRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientDAOImpl implements IClientDAO{

    @Autowired
    ClientRep rep;

    @Override
    public Client create(Client client) {

        Long id = (long) (rep.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        client.setId(id);

        rep.save(client);

        return client;
    }

    @Override
    public Client update(Client client) {

        client.setId(client.getId());

        rep.save(client);

        return client;
    }
}
