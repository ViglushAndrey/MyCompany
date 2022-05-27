package com.example.mycompany.DTO.Auto.Type2;

public class AutoDTOCreate2 {

    private String registrationNumber;
    private String fuelType;
    private String numberOfSeats;
    private String numberOfDoors;
    private String bodyColor;
    private String bodyType;
    private String yearOfTheCar;
    private Long rental;
    private Long sales;

    public AutoDTOCreate2() {
    }

    public AutoDTOCreate2(String registrationNumber, String fuelType, String numberOfSeats, String numberOfDoors, String bodyColor, String bodyType, String yearOfTheCar, Long rental, Long sales) {
        this.registrationNumber = registrationNumber;
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.bodyColor = bodyColor;
        this.bodyType = bodyType;
        this.yearOfTheCar = yearOfTheCar;
        this.rental = rental;
        this.sales = sales;
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

    public Long getRental() {
        return rental;
    }

    public void setRental(Long rental) {
        this.rental = rental;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }
}
