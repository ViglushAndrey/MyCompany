package com.example.mycompany.DTO.Auto;

import lombok.Data;


public class AutoDTOUpdate {

    private Long id;
    private String registrationNumber;
    private String fuelType;
    private String numberOfSeats;
    private String numberOfDoors;
    private String bodyColor;
    private String bodyType;
    private String yearOfTheCar;
    private Long carModel;

    public AutoDTOUpdate() {
    }

    public AutoDTOUpdate(Long id, String registrationNumber, String fuelType, String numberOfSeats, String numberOfDoors, String bodyColor, String bodyType, String yearOfTheCar, Long carModel) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.bodyColor = bodyColor;
        this.bodyType = bodyType;
        this.yearOfTheCar = yearOfTheCar;
        this.carModel = carModel;

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

    public Long getCarModel() {
        return carModel;
    }

    public void setCarModel(Long carModel) {
        this.carModel = carModel;
    }


}
