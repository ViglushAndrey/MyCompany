package com.example.mycompany.repository;

import com.example.mycompany.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {

    Optional<Auto> findCarByRegistrationNumber(String registrationNumber);
  /*  Optional<Auto> findCarByProgram_Id(Long id);

    List<Auto> findAllByMarksIn(Collection<Mark> marks);

    @Query(value = "SELECT c.id, c.registrationNumber, c.bodyColor FROM auto as c where c.id = :id")
    Optional<Auto> findMyCar(Long id);*/

}
