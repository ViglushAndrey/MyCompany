package com.example.mycompany.DTO.Auto;

import lombok.Data;

@Data
public class AutoRequest {

    private String registrationNumber;
    private String fuelType;
    private String numberOfSeats;
    private String numberOfDoors;
    private String bodyColor;
    private String bodyType;
    private String yearOfTheCar;

}
