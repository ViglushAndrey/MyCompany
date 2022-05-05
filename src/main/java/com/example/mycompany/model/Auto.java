package com.example.mycompany.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "auto")
public class Auto {

    @Id
    private Long id;

    private String registrationNumber;
    private String fuelType;
    private String numberOfSeats;
    private String numberOfDoors;
    private String bodyColor;
    private String bodyType;
    private String yearOfTheCar;

    @OneToMany(mappedBy = "auto")
    private Set<Mark> carMark;
    @OneToMany(mappedBy = "auto")
    private Set<Model> carModel;

    @OneToOne(mappedBy = "auto")
    private Client clients;

    @OneToOne(mappedBy = "auto")
    private Collaborator collaborator;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;
}
