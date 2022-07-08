package ru.springmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.springmanager.model.NoSuchTaskException;
import ru.springmanager.model.Task;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    TaskRepository taskRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new TaskValidator());
    }

    @RequestMapping("/{taskId}")
    public String showTaskFromAll(
            @PathVariable("taskId") Task b,
            Model model) throws NoSuchTaskException {
//        Task b = taskService.find(taskId);
        if (b!=null){
            model.addAttribute("task", b);
            return "task";
        }else{
            throw new NoSuchTaskException("Error task id");
        }
    }

    @RequestMapping("/findall")
    public String findAll(Model model){
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "all_tasks";
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String addTask(Model model){
        Task b = new Task();
        model.addAttribute("task", b);
        return "add_task";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String saveTask(
            @Valid @ModelAttribute("task") Task task,
            Errors errors,
            Model model,
            RedirectAttributes attr){
        if (errors.hasErrors()){
            model.addAttribute("task", task);
            return "add_task";
        }else{
            attr.addFlashAttribute("task", task);
            taskService.changeStatus(task);
            taskService.save(task);
            return "redirect:/tasks/task";
        }
    }
    @RequestMapping("/task")
    public String showTask(
            @ModelAttribute("task") Task a,
            Model model
    ) {
        if (a.getId() != null) {
            model.addAttribute("task", a);
            return "task";
        }
        else return "error";
    }
    @RequestMapping("/{taskId}/changeStatus")
    public String changeStatus(
            @PathVariable("taskId") Task b,
            Model model) throws NoSuchTaskException {
//        Task b = taskService.find(taskId);
        if (b!=null){
            taskService.changeStatus(b);
            taskService.save(b);
            model.addAttribute("task", b);

            return "task";
        }else{
            throw new NoSuchTaskException("Error task id");
        }
    }
//    @RequestMapping(value="/find", method = RequestMethod.GET)
//    public String findEmployee(Model model){
//        Task b = new Task();
//        model.addAttribute("task", b);
//        return "add_task";
//    }
}
