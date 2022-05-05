package com.example.mycompany.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalTime;
import java.util.Set;

@Data
@Entity(name = "sales")
public class Sales {

    @Id
    private Long id;

    @OneToMany(mappedBy = "sales")
    private Set<Auto> auto;

    @OneToMany(mappedBy = "sales")
    private Set<Moto> moto;

    @OneToOne(mappedBy = "sales")
    private Client client;

    @OneToOne(mappedBy = "sales")
    private Collaborator collaborator;

    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime dayOfSale;
}
