package com.example.mycompany.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "collaborator")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Collaborator {

    @Id
    private Long id;

    private String name;
    private String position;
    private String tel;

    @JsonManagedReference
    @OneToMany(mappedBy = "collaborators",  fetch = FetchType.EAGER)
    private Set<Rental> rental;

    @JsonManagedReference
    @OneToMany(mappedBy = "collaborator",  fetch = FetchType.EAGER)
    private Set<Sales> sale;
}
