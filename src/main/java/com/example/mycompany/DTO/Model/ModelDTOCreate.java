package com.example.mycompany.DTO.Model;

import lombok.Data;


public class ModelDTOCreate {

    private String carModel;
    private Long mark;

    public ModelDTOCreate() {
    }

    public ModelDTOCreate(String carModel, Long mark) {
        this.carModel = carModel;
        this.mark = mark;
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
