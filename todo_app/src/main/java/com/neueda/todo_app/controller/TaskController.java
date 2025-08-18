package com.neueda.todo_app.controller;

import com.neueda.todo_app.repository.Status;
import com.neueda.todo_app.repository.StatusRepository;
import com.neueda.todo_app.repository.Task;
import com.neueda.todo_app.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    TaskRepository taskRepository;
    StatusRepository statusRepository;
    public TaskController(TaskRepository taskRepository,StatusRepository statusRepository) {
        this.taskRepository = taskRepository;
        this.statusRepository = statusRepository;
        Status status = new Status(null, "NOT_COMPLETED");
        this.statusRepository.save(status);
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

        statusRepository.save(task.getStatus());
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public void updateItem(@RequestBody Task task,@PathVariable Long id) {


        taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
