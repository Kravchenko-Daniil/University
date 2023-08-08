package com.example.app.Task912.library;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String publisher;

    private String student;

    private Date issue_date;

    private Date received_date;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name)    {
        this.name = name;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public void setStudent(String student) {this.student = student;}

    public void setIssue_date(Date issue_date) {this.issue_date = issue_date;}

    public void setReceived_date(Date received_date) {this.received_date = received_date;}

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPublisher(){
        return publisher;
    }

    public String getStudent(){return student;}

    public Date getIssue_date(){return issue_date;}

    public Date getReceived_date(){return received_date;}

    @Override
    public String toString() {
        return ""+getId()+" "+ getName()+" "+getPublisher()+" "+ getStudent()+" "+getIssue_date()+" "+getReceived_date();
    }
}
