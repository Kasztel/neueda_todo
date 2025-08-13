package com.neueda.todo_app.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    ArrayList<String> list = new ArrayList<>(List.of("Item1", "Item2", "item3"));

    @Override
    public List<String> getAllTasks() {
        return list;
    }

    @Override
    public String getTaskById(String id) {
            return list.get(Integer.parseInt(id));
    }

    @Override
    public boolean createTask(String item) {
        return list.add(item);
    }

    @Override
    public void updateTask(String id, String item) {
        list.remove(Integer.parseInt(id));
        list.add(item);
    }

    @Override
    public void deleteTask(String id) {
        list.remove(Integer.parseInt(id));
    }


}
