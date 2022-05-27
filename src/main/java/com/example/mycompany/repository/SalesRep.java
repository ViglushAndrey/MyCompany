package com.example.mycompany.repository;

import com.example.mycompany.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRep extends JpaRepository<Sales, Long> {
}
