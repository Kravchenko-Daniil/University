package com.example.app.Task912.conferences;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "conferences")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date date;
    private String moderator;
    private String speaker;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {this.name = name;}

    public void setModerator(String moderator) {this.moderator = moderator;}

    public void setDate(Date date) {this.date = date;}

    public void setSpeaker(String speaker) {this.speaker = speaker;}

    public Long getId() {return id;}

    public String getName() {return name;}

    public Date getDate() {return date;}

    public String getModerator() {return moderator;}

    public String getSpeaker() {return speaker;}
}
