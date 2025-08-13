package com.neueda.todo_app.service;

import com.neueda.todo_app.repository.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface TaskService {
    public List<Task> getAllTasks();
    public Task getTaskById(@PathVariable Integer id);
    public boolean createTask(@RequestBody Task task);
    public void updateTask(@PathVariable Integer id, @RequestBody Task task);
    public void deleteTask(@PathVariable Integer id);

}
