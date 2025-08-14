package com.neueda.todo_app.repository;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String title;
    private final String description;
    @ManyToOne
    @JoinColumn(name="status_id")
    private final Status status;
    private final String category;
    private final Date reminder;
    private final Date deadline;

    private Task(Long id, Builder builder) {
        this.id = id;
        this.title = builder.title;
        this.description = builder.description;
        this.status = builder.status;
        this.category = builder.category != null ? builder.category : "All";
        this.reminder = builder.reminder;
        this.deadline = builder.deadline;
    }

    public Task(Long id) {
        this.id = id;
        this.title = null;
        this.description = null;
        this.status = null;
        this.category = "All";
        this.reminder = null;
        this.deadline = null;
    }


    public static class Builder {
        private String title;
        private String description;
        private Status status;
        private String category;
        private Date reminder;
        private Date deadline;


        public Builder( String title, String description, Status status) {
            this.title = title;
            this.description = description;
            this.status = status;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder reminder(Date reminder) {
            this.reminder = reminder;
            return this;
        }

        public Builder deadline(Date deadline) {
            this.deadline = deadline;
            return this;
        }


        public Task build(Long id) {
            return new Task(id, this);
        }
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }

    public Date getReminder() {
        return reminder;
    }

    public Date getDeadline() {
        return deadline;
    }
}
