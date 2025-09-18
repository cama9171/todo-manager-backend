package com.dev.task_manager_backend.service;

import com.dev.task_manager_backend.modal.Task;
import com.dev.task_manager_backend.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    public Task updateTask(long id, Task task) {
        return taskRepo.save(task);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    public Task getTask(Long id) {
        return taskRepo.findById(id).orElse(null);
    }
}
