package ru.springmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;
import ru.springmanager.model.Task;

public class TaskConverter implements Converter<Integer, Task> {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @Override
    public Task convert(Integer code) {
        return taskService.find(code);
    }

}
