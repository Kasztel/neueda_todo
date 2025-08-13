package com.neueda.todo_app.controller;

import com.neueda.todo_app.repository.Task;
import com.neueda.todo_app.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }


    @GetMapping("/{id}")
    public Task getItem(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public boolean createItem(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable Integer id, @RequestBody Task task) {
        taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }
}
