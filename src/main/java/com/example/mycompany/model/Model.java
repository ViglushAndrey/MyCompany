package com.example.mycompany.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "modelies")
public class Model {

    @Id
    private Long id;

    private String carModel;

    @ManyToOne
    @JoinColumn(name = "auto_id")
    private Auto auto;
    @ManyToOne
    @JoinColumn(name = "moto_id")
    private Moto moto;
}
