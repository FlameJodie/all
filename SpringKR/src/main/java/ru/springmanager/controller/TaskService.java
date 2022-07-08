package ru.springmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springmanager.model.Task;

import java.util.List;

@Service("taskService")
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Task find(Integer taskId) {
        return taskRepository.findOne(taskId);
    }
    public void save(Task b){
        taskRepository.save(b);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void changeStatus(Task b) {
        if (b.getIsDone() == null || b.getIsDone()) {
            b.setIsDone(false);
        }
        else b.setIsDone(true);

    }
}
