package com.neueda.todo_app.controller;

import com.neueda.todo_app.repository.Task;
import com.neueda.todo_app.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }


    @GetMapping("/{id}")
    public Task getItem(@PathVariable Long id) {
        return taskRepository.findById(id).get();
    }

    @PostMapping
    public Task createItem(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public void updateItem(@RequestBody Task task) {
        taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
