package com.neueda.todo_app.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;

@Entity
public class Status {
    //NOT_STARTED("Not started"), IN_PROGRESS("In progress"), COMPLETED("Completed");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String status;

    public Status() {
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public Status(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}
