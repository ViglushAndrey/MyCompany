package com.example.mycompany.DTO.Mark;

import lombok.Data;


public class MarkDTOCreate {

    private String transportmark;

    public MarkDTOCreate() {
    }

    public MarkDTOCreate(String transportmark) {
        this.transportmark = transportmark;
    }

    public String getTransportmark() {
        return transportmark;
    }

    public void setTransportmark(String transportmark) {
        this.transportmark = transportmark;
    }
}
