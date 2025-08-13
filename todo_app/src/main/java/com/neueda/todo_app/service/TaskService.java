package com.neueda.todo_app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface TaskService {
    public List<String> getAllTasks();
    public String getTaskById(@PathVariable String id);
    public boolean createTask(@RequestBody String task);
    public void updateTask(@PathVariable String id, @RequestBody String task);
    public void deleteTask(@PathVariable String id);

}
