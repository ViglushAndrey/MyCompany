package com.example.mycompany.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "moto")
@Builder

public class Moto {

    @Id
    private Long id;

    private String registrationNumber;
    private String fuelType;
    private String numberOfSeats;
    private String bodyColor;
    private String bodyType;
    private String yearOfTheMoto;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "motoModel_id")
    private Model motoModel;

    @JsonManagedReference
    @OneToMany(mappedBy = "moto", fetch = FetchType.EAGER)
    private Set<Rental> rental;

    @JsonManagedReference
    @OneToMany(mappedBy = "moto", fetch = FetchType.EAGER)
    private Set<Sales> sales;

    public Moto() {
    }

    public Moto(Long id, String registrationNumber, String fuelType, String numberOfSeats, String bodyColor, String bodyType, String yearOfTheMoto, Model motoModel, Set<Rental> rental, Set<Sales> sales) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.bodyColor = bodyColor;
        this.bodyType = bodyType;
        this.yearOfTheMoto = yearOfTheMoto;
        this.motoModel = motoModel;
        this.rental = rental;
        this.sales = sales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getYearOfTheMoto() {
        return yearOfTheMoto;
    }

    public void setYearOfTheMoto(String yearOfTheMoto) {
        this.yearOfTheMoto = yearOfTheMoto;
    }

    public Model getMotoModel() {
        return motoModel;
    }

    public void setMotoModel(Model motoModel) {
        this.motoModel = motoModel;
    }

    public Set<Rental> getRental() {
        return rental;
    }

    public void setRental(Set<Rental> rental) {
        this.rental = rental;
    }

    public Set<Sales> getSales() {
        return sales;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", numberOfSeats='" + numberOfSeats + '\'' +
                ", bodyColor='" + bodyColor + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", yearOfTheMoto='" + yearOfTheMoto + '\'' +
                ", motoModel=" + motoModel +
                ", rental=" + rental +
                ", sales=" + sales +
                '}';
    }
}
