package com.example.mycompany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity(name = "mark")
@Builder
public class Mark {

    @Id
    private Long id;


    private String transportmark;

    @JsonBackReference
    @OneToMany(mappedBy = "mark", fetch = FetchType.EAGER)
    private Set<Model> model;


    public Mark() {
    }

    public Mark(Long id, String transportmark, Set<Model> model) {
        this.id = id;
        this.transportmark = transportmark;
        this.model = model;
    }

    public Mark(String transportmark, Set<Model> model) {
        this.transportmark = transportmark;
        this.model = model;
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

    public Set<Model> getModel() {
        return model;
    }

    public void setModel(Set<Model> model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", transportmark='" + transportmark + '\'' +
                ", model=" + model +
                '}';
    }
}
