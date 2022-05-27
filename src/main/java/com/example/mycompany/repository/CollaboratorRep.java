package com.example.mycompany.repository;

import com.example.mycompany.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRep extends JpaRepository<Collaborator, Long> {
}
