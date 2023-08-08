package com.example.app.Task912.cinema;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "cinema")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String studio;

    private Date date;

    private Integer ticketCount;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {this.name = name;}

    public void setStudio(String studio) {this.studio = studio;}

    public void setDate(Date date) {this.date = date;}

    public void setTicketCount(Integer ticketCount) {this.ticketCount = ticketCount;}

    public Long getId() {return id;}

    public String getName() {return name;}

    public String getStudio() {return studio;}

    public Date getDate() {return date;}

    public Integer getTicketCount() {return ticketCount;}
}
