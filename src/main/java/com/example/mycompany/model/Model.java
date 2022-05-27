package com.example.mycompany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "model")
@Builder

public class Model {

    @Id
    private Long id;

    private String carModel;

    @JsonBackReference
    @OneToMany(mappedBy = "carModel", fetch = FetchType.EAGER)
    private Set<Auto> auto;

    @JsonBackReference
    @OneToMany(mappedBy = "motoModel", fetch = FetchType.EAGER)
    private Set<Moto> moto;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mark_id")
    private Mark mark;

    public Model() {
    }

    public Model(Long id, String carModel, Set<Auto> auto, Set<Moto> moto, Mark mark) {
        this.id = id;
        this.carModel = carModel;
        this.auto = auto;
        this.moto = moto;
        this.mark = mark;
    }

    public Model(String carModel, Set<Auto> auto, Set<Moto> moto, Mark mark) {
        this.carModel = carModel;
        this.auto = auto;
        this.moto = moto;
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Set<Auto> getAuto() {
        return auto;
    }

    public void setAuto(Set<Auto> autos) {
        this.auto = autos;
    }

    public Set<Moto> getMoto() {
        return moto;
    }

    public void setMoto(Set<Moto> motos) {
        this.moto = motos;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", carModel='" + carModel + '\'' +
                ", autos=" + auto +
                ", motos=" + moto +
                ", mark=" + mark +
                '}';
    }
}
