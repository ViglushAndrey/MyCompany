package com.example.mycompany.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity(name = "clients")
public class Client {

    @Id
    private Long id;

    private String name;
    private String address;
    private String tel;

    @OneToOne
    @JoinColumn(name = "auto_id")
    private Auto auto;

    @OneToOne
    @JoinColumn(name = "moto_id")
    private Moto moto;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @OneToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;
}
