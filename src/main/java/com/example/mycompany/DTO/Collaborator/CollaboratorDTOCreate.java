package com.example.mycompany.DTO.Collaborator;

import lombok.Data;


public class CollaboratorDTOCreate {

    private String name;
    private String position;
    private String tel;

    public CollaboratorDTOCreate() {
    }

    public CollaboratorDTOCreate(String name, String position, String tel) {
        this.name = name;
        this.position = position;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
