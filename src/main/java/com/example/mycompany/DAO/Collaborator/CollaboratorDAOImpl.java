package com.example.mycompany.DAO.Collaborator;

import com.example.mycompany.model.Collaborator;
import com.example.mycompany.repository.CollaboratorRep;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorDAOImpl implements ICollaboratorDAO{

    @Autowired
    CollaboratorRep rep;

    @Override
    public Collaborator create(Collaborator collaborator) {

        Long id = (long) (rep.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        collaborator.setId(id);

        rep.save(collaborator);

        return collaborator;
    }

    @Override
    public Collaborator update(Collaborator collaborator) {

        collaborator.setId(collaborator.getId());

        rep.save(collaborator);

        return collaborator;
    }
}
