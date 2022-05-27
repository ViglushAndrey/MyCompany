package com.example.mycompany.repository;

import com.example.mycompany.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRep extends JpaRepository<Rental, Long> {
}
