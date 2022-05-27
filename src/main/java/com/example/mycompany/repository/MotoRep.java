package com.example.mycompany.repository;

import com.example.mycompany.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotoRep extends JpaRepository<Moto, Long> {

    Optional<Moto> findTypeByRegistrationNumber(String registrationNumber);
 /*   Optional<Moto> findTypeByProgram_Id(Long id);

    List<Moto> findAllByProgramsIn(Collection<Mark> marks);

    @Query(value = "SELECT c.id, c.registrationNumber, c.transportmark FROM auto as c where c.id = :id")
    Optional<Moto> findMyType(Long id);
*/
}
