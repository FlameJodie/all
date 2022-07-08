package ru.springmanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "department")
    private String department;

    @NotNull
    @Column(name = "task_name")
    private String taskName;

    @Column(name = "payment")
    private Integer payment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "isDone")
    private Boolean isDone;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", taskName='" + taskName + '\'' +
                ", payment=" + payment +
                ", deadline=" + deadline +
                ", isDone=" + isDone +
                '}';
    }
}
