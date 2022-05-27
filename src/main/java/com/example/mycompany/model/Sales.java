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


@Entity(name = "sales")
@Builder
public class Sales {

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

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collaborator_id")
    private Collaborator collaborator;

    private LocalDate dayOfSale;

    public Sales() {
    }

    public Sales(Long id, Auto auto, Moto moto, Client client, Collaborator collaborator, LocalDate dayOfSale) {
        this.id = id;
        this.auto = auto;
        this.moto = moto;
        this.client = client;
        this.collaborator = collaborator;
        this.dayOfSale = dayOfSale;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public LocalDate getDayOfSale() {
        return dayOfSale;
    }

    public void setDayOfSale(LocalDate dayOfSale) {
        this.dayOfSale = dayOfSale;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", auto=" + auto +
                ", moto=" + moto +
                ", client=" + client +
                ", collaborator=" + collaborator +
                ", dayOfSale=" + dayOfSale +
                '}';
    }
}
