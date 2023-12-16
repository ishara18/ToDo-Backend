package com.example.demo.controller;

import com.example.demo.dto.TaskDTO;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/task")
@CrossOrigin
public class Tasks {
    @Autowired
    private TaskService taskService;

    @GetMapping("/gettasks")
    public List<TaskDTO> getTask(){
        return taskService.getAllTasks();
    }

    @PostMapping("/savetask")
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO){
       return taskService.saveTask(taskDTO);
    }

    @PutMapping("/updatetask")
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO){

        return taskService.updateTask(taskDTO);
    }

    @DeleteMapping("/deletetask")
    public boolean deleteTask(@RequestBody TaskDTO taskDTO){

        return taskService.deleteTask(taskDTO);
    }
}
