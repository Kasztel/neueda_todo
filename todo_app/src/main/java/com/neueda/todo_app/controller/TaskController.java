package com.neueda.todo_app.controller;

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
    public List<String> getTasks() {
        return taskService.getAllTasks();
    }


    @GetMapping("/{id}")
    public String getItem(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public boolean createItem(@RequestBody String item) {
        return taskService.createTask(item);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable String id, @RequestBody String item) {
        taskService.updateTask(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        taskService.deleteTask(id);
    }
}
