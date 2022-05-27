package com.example.mycompany.DAO.Collaborator;

import com.example.mycompany.model.Client;
import com.example.mycompany.model.Collaborator;
import org.springframework.stereotype.Service;

@Service
public interface ICollaboratorDAO {

    Collaborator create (Collaborator collaborator);
    Collaborator update (Collaborator collaborator);

}
