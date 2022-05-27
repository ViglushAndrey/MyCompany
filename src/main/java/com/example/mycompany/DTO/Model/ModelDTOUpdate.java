package com.example.mycompany.DTO.Model;

import lombok.Data;


public class ModelDTOUpdate {

    private Long id;
    private String carModel;
    private Long mark;

    public ModelDTOUpdate() {
    }

    public ModelDTOUpdate(Long id, String carModel, Long mark) {
        this.id = id;
        this.carModel = carModel;
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

    public Long getMark() {
        return mark;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }
}
