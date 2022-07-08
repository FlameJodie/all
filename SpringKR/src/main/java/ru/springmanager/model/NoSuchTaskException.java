package ru.springmanager.model;

public class NoSuchTaskException extends Throwable {
    public NoSuchTaskException(String error_task_id) {
        super(error_task_id);
    }
}
