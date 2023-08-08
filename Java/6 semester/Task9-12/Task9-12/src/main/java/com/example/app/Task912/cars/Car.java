package com.example.app.Task912.cars;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private Integer year;

    private Date registrationDate;

    private String owner;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Integer getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return ""+getId()+" "+ getBrand()+" "+getYear()+" "+getRegistrationDate()+" "+getOwner();
    }
}
