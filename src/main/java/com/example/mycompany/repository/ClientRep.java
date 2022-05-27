package com.example.mycompany.repository;

import com.example.mycompany.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRep extends JpaRepository<Client, Long> {
}
