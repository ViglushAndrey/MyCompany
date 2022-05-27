package com.example.mycompany.repository;

import com.example.mycompany.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRep extends JpaRepository<Model, Long> {
}
