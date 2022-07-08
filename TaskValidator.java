package ru.springmanager.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.springmanager.model.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TaskValidator implements Validator {
    @Override
    public boolean supports(Class<?> type) {
        return Task.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Task task = (Task) o;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        LocalDate taskDate = task.getDeadline();

        if (localDate.compareTo(taskDate) > 0) {
            errors.rejectValue(
                    "deadline", "task.deadline", "The deadline date is older than the current date"
            );
        }
    }
}