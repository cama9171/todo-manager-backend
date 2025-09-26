package com.dev.task_manager_backend.service;

import com.dev.task_manager_backend.dto.TaskDTO;
import com.dev.task_manager_backend.modal.Task;
import com.dev.task_manager_backend.modal.User;
import com.dev.task_manager_backend.repository.TaskRepo;
import com.dev.task_manager_backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task addTask(TaskDTO taskDTO) {
        User user1 = userRepo.findById(taskDTO.getUserId()).orElse(null);

        Task task1 = new Task();
        task1.setTitle(taskDTO.getTitle());
        task1.setStatus(taskDTO.isStatus());
        task1.setUser(user1);

        return taskRepo.save(task1);
    }

    public Task updateTask(long id, TaskDTO taskDTO) {
        User user1 = userRepo.findById(taskDTO.getUserId()).orElse(null);

        Task task1 = new Task();
        task1.setTitle(taskDTO.getTitle());
        task1.setStatus(taskDTO.isStatus());
        task1.setUser(user1);

        return taskRepo.save(task1);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    public Task getTask(Long id) {
        return taskRepo.findById(id).orElse(null);
    }
}
