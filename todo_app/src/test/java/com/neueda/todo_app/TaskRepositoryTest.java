package com.neueda.todo_app;


import com.neueda.todo_app.repository.Status;
import com.neueda.todo_app.repository.StatusRepository;
import com.neueda.todo_app.repository.Task;
import com.neueda.todo_app.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Test
    public void testSaveAndFindTask() {
        Status status = new Status(null, "NOT_STARTED");
        Task task = new Task.Builder("Title", "Desc", status)
                .deadline(new Date())
                .build(null);
        statusRepository.save(status);
        Task saved = taskRepository.save(task);
        Task found = taskRepository.findById(saved.getId()).orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getTitle()).isEqualTo("Title");
    }
}

