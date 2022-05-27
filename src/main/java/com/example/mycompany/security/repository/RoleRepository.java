package com.example.mycompany.security.repository;

import com.example.mycompany.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Role.ERole name);
}
