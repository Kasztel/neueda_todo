//package com.neueda.todo_app.service;
//
//import com.neueda.todo_app.repository.Task;
//import com.neueda.todo_app.repository.TaskRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class TaskServiceImpl implements TaskService {
//    TaskRepository tasklist = new TaskRepository();
//
//
//    @Override
//    public List<Task> getAllTasks() {
//        return tasklist.getTasklist();
//    }
//
//    @Override
//    public Task getTaskById(Integer id) {
//            return tasklist.get(id);
//    }
//
//    @Override
//    public boolean createTask(Task task) {
//        return tasklist.add(task);
//    }
//
//    @Override
//    public void updateTask(Integer id, Task task) {
//        tasklist.remove(id);
//        tasklist.add(task);
//    }
//
//    @Override
//    public void deleteTask(Integer id) {
//        tasklist.remove(id);
//    }
//
//
//}
