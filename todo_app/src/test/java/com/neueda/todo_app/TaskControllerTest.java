package com.neueda.todo_app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neueda.todo_app.repository.Status;
import com.neueda.todo_app.repository.Task;
import com.neueda.todo_app.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Task sampleTask;

    @BeforeEach
    public void setup() {
        taskRepository.deleteAll();
        Status status = new Status(1L, "IN_PROGRESS");
        sampleTask = new Task.Builder("Test Task", "Test Description", status)
                .category("Work")
                .reminder(new Date())
                .deadline(new Date())
                .build(null);
        sampleTask = taskRepository.save(sampleTask);
    }

    @Test
    public void testGetAllTasks() throws Exception {
        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Task"));
    }

    @Test
    public void testGetTaskById() throws Exception {
        mockMvc.perform(get("/api/tasks/" + sampleTask.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Test Description"));
    }

    @Test
    public void testCreateTask() throws Exception {
        Status status = new Status(2L, "NOT_STARTED");
        Task newTask = new Task.Builder("New Task", "New Desc", status)
                .category("Personal")
                .build(null);

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newTask)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("New Task"));
    }

    @Test
    public void testDeleteTask() throws Exception {
        mockMvc.perform(delete("/api/tasks/" + sampleTask.getId()))
                .andExpect(status().isOk());
    }
}
