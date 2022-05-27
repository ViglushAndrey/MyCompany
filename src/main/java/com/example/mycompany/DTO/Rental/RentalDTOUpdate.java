package com.example.mycompany.DTO.Rental;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


public class RentalDTOUpdate {

    private Long id;
    private LocalDate rentalStartDate;
    private Long numberOfRentalDays;
    private Long auto;
    private Long moto;
    private Long clients;
    private Long collaborators;

    public RentalDTOUpdate() {
    }

    public RentalDTOUpdate(Long id, LocalDate rentalStartDate, Long numberOfRentalDays, Long auto, Long moto, Long clients, Long collaborators) {
        this.id = id;
        this.rentalStartDate = rentalStartDate;
        this.numberOfRentalDays = numberOfRentalDays;
        this.auto = auto;
        this.moto = moto;
        this.clients = clients;
        this.collaborators = collaborators;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public Long getNumberOfRentalDays() {
        return numberOfRentalDays;
    }

    public void setNumberOfRentalDays(Long numberOfRentalDays) {
        this.numberOfRentalDays = numberOfRentalDays;
    }

    public Long getAuto() {
        return auto;
    }

    public void setAuto(Long auto) {
        this.auto = auto;
    }

    public Long getMoto() {
        return moto;
    }

    public void setMoto(Long moto) {
        this.moto = moto;
    }

    public Long getClients() {
        return clients;
    }

    public void setClients(Long clients) {
        this.clients = clients;
    }

    public Long getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(Long collaborators) {
        this.collaborators = collaborators;
    }
}
