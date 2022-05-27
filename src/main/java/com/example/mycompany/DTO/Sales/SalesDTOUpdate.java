package com.example.mycompany.DTO.Sales;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


public class SalesDTOUpdate {

    private Long id;
    private LocalDate dayOfSale;
    private Long auto;
    private Long moto;
    private Long client;
    private Long collaborator;

    public SalesDTOUpdate() {
    }

    public SalesDTOUpdate(Long id, LocalDate dayOfSale, Long auto, Long moto, Long client, Long collaborator) {
        this.id = id;
        this.dayOfSale = dayOfSale;
        this.auto = auto;
        this.moto = moto;
        this.client = client;
        this.collaborator = collaborator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDayOfSale() {
        return dayOfSale;
    }

    public void setDayOfSale(LocalDate dayOfSale) {
        this.dayOfSale = dayOfSale;
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

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Long collaborator) {
        this.collaborator = collaborator;
    }
}
