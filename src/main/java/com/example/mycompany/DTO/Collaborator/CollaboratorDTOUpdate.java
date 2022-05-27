package com.example.mycompany.DTO.Collaborator;

import lombok.Data;


public class CollaboratorDTOUpdate {

    private Long id;
    private String name;
    private String position;
    private String tel;

    public CollaboratorDTOUpdate() {
    }

    public CollaboratorDTOUpdate(Long id, String name, String position, String tel) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
