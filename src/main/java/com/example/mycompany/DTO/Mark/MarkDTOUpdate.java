package com.example.mycompany.DTO.Mark;

import lombok.Data;


public class MarkDTOUpdate {
    private Long id;
    private String transportmark;


    public MarkDTOUpdate() {
    }

    public MarkDTOUpdate(Long id, String transportmark) {
        this.id = id;
        this.transportmark = transportmark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransportmark() {
        return transportmark;
    }

    public void setTransportmark(String transportmark) {
        this.transportmark = transportmark;
    }
}
