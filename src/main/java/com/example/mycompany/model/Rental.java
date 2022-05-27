package com.example.mycompany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;


@Entity(name = "rental")
@Builder
public class Rental {

    @Id
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auto_id")
    private Auto auto;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moto_id")
    private Moto moto;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client clients;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collaborators_id")
    private  Collaborator collaborators;

    private LocalDate rentalStartDate;

    private Long numberOfRentalDays;

    public Rental() {
    }

    public Rental(Long id, Auto auto, Moto moto, Client clients, Collaborator collaborators, LocalDate rentalStartDate, Long numberOfRentalDays) {
        this.id = id;
        this.auto = auto;
        this.moto = moto;
        this.clients = clients;
        this.collaborators = collaborators;
        this.rentalStartDate = rentalStartDate;
        this.numberOfRentalDays = numberOfRentalDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    public Collaborator getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(Collaborator collaborators) {
        this.collaborators = collaborators;
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

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", auto=" + auto +
                ", moto=" + moto +
                ", clients=" + clients +
                ", collaborators=" + collaborators +
                ", rentalStartDate=" + rentalStartDate +
                ", numberOfRentalDays=" + numberOfRentalDays +
                '}';
    }
}
