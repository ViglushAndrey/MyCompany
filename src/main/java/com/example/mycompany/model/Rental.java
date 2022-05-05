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
@Entity(name = "rental")
public class Rental {

    @Id
    private Long id;

    @OneToMany(mappedBy = "rental")
    private Set<Auto> auto;

    @OneToMany(mappedBy = "rental")
    private Set<Moto> moto;

    @OneToOne(mappedBy = "rental")
    private Client client;

    @OneToOne(mappedBy = "rental")
    private Collaborator collaborator;

    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime rentalStartDate;

    private Long numberOfRentalDays;
}
