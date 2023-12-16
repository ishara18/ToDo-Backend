package com.example.demo.service;

import com.example.demo.dto.TaskDTO;
import com.example.demo.entity.Task;
import com.example.demo.repo.TaskRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private ModelMapper modelMapper;

    public TaskDTO saveTask(TaskDTO taskDTO){
        Task savedTask = taskRepo.save(modelMapper.map(taskDTO, Task.class));
        return modelMapper.map(savedTask, TaskDTO.class);
    }

    public List<TaskDTO> getAllTasks(){
        List<Task>taskList=taskRepo.findAll();
        return modelMapper.map(taskList, new TypeToken<List<TaskDTO>>(){}.getType());
    }

    public TaskDTO updateTask(TaskDTO taskDTO){
        taskRepo.save(modelMapper.map(taskDTO, Task.class));
        return taskDTO;
    }

    public boolean deleteTask(TaskDTO taskDTO){
        taskRepo.delete(modelMapper.map(taskDTO, Task.class));
        return true;
    }
}
