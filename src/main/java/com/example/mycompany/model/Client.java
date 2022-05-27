package com.example.mycompany.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "clients")
@Builder
public class Client {

    @Id
    private Long id;

    private String name;
    private String address;
    private String tel;

    @JsonManagedReference
    @OneToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    private Set<Rental> rentals;

    @JsonManagedReference
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Sales> sales;

    public Client() {
    }

    public Client(Long id, String name, String address, String tel, Set<Rental> rentals, Set<Sales> sales) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.rentals = rentals;
        this.sales = sales;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }

    public Set<Sales> getSales() {
        return sales;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", rentals=" + rentals +
                ", sales=" + sales +
                '}';
    }
}
