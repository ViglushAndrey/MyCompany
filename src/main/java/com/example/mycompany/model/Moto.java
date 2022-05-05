package com.example.mycompany.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "moto")
public class Moto {

    @Id
    private Long id;

    private String registrationNumber;
    private String fuelType;
    private String numberOfSeats;
    private String bodyColor;
    private String bodyType;
    private String yearOfTheMoto;

    @OneToMany(mappedBy = "moto")
    private Set<Mark> motoMark;
    @OneToMany(mappedBy = "moto")
    private Set<Model> motoModel;

    @OneToOne(mappedBy = "moto")
    private Client clients;

    @OneToOne(mappedBy = "moto")
    private Collaborator collaborator;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;
}
