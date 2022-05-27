package com.example.mycompany.DTO.Moto;

import lombok.Data;


public class MotoDTOUpdate {

    private Long id;
    private String registrationNumber;
    private String fuelType;
    private String numberOfSeats;
    private String bodyColor;
    private String bodyType;
    private String yearOfTheMoto;
    private Long motoModel;


    public MotoDTOUpdate() {
    }

    public MotoDTOUpdate(Long id, String registrationNumber, String fuelType, String numberOfSeats, String bodyColor, String bodyType, String yearOfTheMoto, Long motoModel) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.bodyColor = bodyColor;
        this.bodyType = bodyType;
        this.yearOfTheMoto = yearOfTheMoto;
        this.motoModel = motoModel;

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

    public Long getMotoModel() {
        return motoModel;
    }

    public void setMotoModel(Long motoModel) {
        this.motoModel = motoModel;
    }


}
