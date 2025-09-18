package com.dev.task_manager_backend.controller;

import com.dev.task_manager_backend.dto.TaskDTO;
import com.dev.task_manager_backend.modal.Task;
import com.dev.task_manager_backend.modal.User;
import com.dev.task_manager_backend.service.TaskService;
import com.dev.task_manager_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskService taskService;
    private UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id){
        return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody TaskDTO taskDTO){
        long userId1 = taskDTO.getUserId();

        User user1 = userService.getUserById(userId1);

        Task task1 = new Task();
        task1.setTitle(taskDTO.getTitle());
        task1.setStatus(taskDTO.isStatus());
        task1.setUser(user1);

        return new ResponseEntity<>(taskService.addTask(task1), HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<String> updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO){
        Task task1 = taskService.getTask(id);

        if(task1 != null){
            User user1 = userService.getUserById(taskDTO.getUserId());

            task1.setTitle(taskDTO.getTitle());
            task1.setStatus(taskDTO.isStatus());
            task1.setUser(user1);

            taskService.updateTask(id, task1);
            return new ResponseEntity<>("Task updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        Task task1 = taskService.getTask(id);

        if(task1 != null){
            taskService.deleteTask(id);
            return new ResponseEntity<>("Task deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Task does not exist!", HttpStatus.BAD_REQUEST);
        }
    }
}
