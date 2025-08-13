package com.neueda.todo_app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

public class Task {
    private final Integer id;
    private final String title;
    private final String description;
    private final Status status;
    private final String category;
    private final Date reminder;
    private final Date deadline;

    private Task(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.status = builder.status;
        this.category = builder.category != null ? builder.category : "All";
        this.reminder = builder.reminder;
        this.deadline = builder.deadline;
    }

    public Task() {
        this.id = null;
        this.title = null;
        this.description = null;
        this.status = null;
        this.category = "All";
        this.reminder = null;
        this.deadline = null;
    }


    public static class Builder {
        private Integer id;
        private String title;
        private String description;
        private Status status;
        private String category;
        private Date reminder;
        private Date deadline;


        public Builder(Integer id, String title, String description, Status status) {
            this.id = id;
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

        public Task build() {
            return new Task(this);
        }
    }

    public Integer getId() {
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
