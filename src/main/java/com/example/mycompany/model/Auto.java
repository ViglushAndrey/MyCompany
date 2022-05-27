package com.example.mycompany.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "auto")
@Builder
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

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carModel_id")
    private Model carModel;

    @JsonManagedReference
    @OneToMany(mappedBy = "auto", fetch = FetchType.EAGER)
    private Set<Rental> rental;

    @JsonManagedReference
    @OneToMany(mappedBy = "auto", fetch = FetchType.EAGER)
    private Set<Sales> sales;

    public Auto() {
    }

    public Auto(Long id, String registrationNumber, String fuelType, String numberOfSeats, String numberOfDoors, String bodyColor, String bodyType, String yearOfTheCar, Model carModel, Set<Rental> rental, Set<Sales> sales) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.bodyColor = bodyColor;
        this.bodyType = bodyType;
        this.yearOfTheCar = yearOfTheCar;
        this.carModel = carModel;
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

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
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

    public String getYearOfTheCar() {
        return yearOfTheCar;
    }

    public void setYearOfTheCar(String yearOfTheCar) {
        this.yearOfTheCar = yearOfTheCar;
    }

    public Model getCarModel() {
        return carModel;
    }

    public void setCarModel(Model carModel) {
        this.carModel = carModel;
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
        return "Auto{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", numberOfSeats='" + numberOfSeats + '\'' +
                ", numberOfDoors='" + numberOfDoors + '\'' +
                ", bodyColor='" + bodyColor + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", yearOfTheCar='" + yearOfTheCar + '\'' +
                ", carModel=" + carModel +
                ", rental=" + rental +
                ", sales=" + sales +
                '}';
    }
}
