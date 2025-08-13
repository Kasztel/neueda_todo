package com.neueda.todo_app.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public class TaskRepository {
    ArrayList<Task> tasklist = new ArrayList<>();

    public TaskRepository() {
        Task task = new Task.Builder(0, "Buy groceries", "Milk, Eggs, Bread", Status.NOT_STARTED)
                .category("Personal")
                .reminder(new Date())
                .deadline(new Date())
                .build();
        tasklist.add(task);
    }

    public ArrayList<Task> getTasklist() {
        return tasklist;
    }

    public void setTasklist(ArrayList<Task> tasklist) {
        this.tasklist = tasklist;
    }

    public Task get(Integer id) {
        return tasklist.get(id);
    }

    public boolean add(Task task) {
        return tasklist.add(task);
    }

    public void remove(Integer id) {
        tasklist.remove(id);
    }
}
