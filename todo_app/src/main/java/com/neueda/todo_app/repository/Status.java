package com.neueda.todo_app.repository;

public enum Status {
    NOT_STARTED("Not started"), IN_PROGRESS("In progress"), COMPLETED("Completed");

    private final String status;

    public String getStatus() {
        return status;
    }

    private Status(String status) {
        this.status = status;
    }
}
