package com.dev.task_manager_backend.controller;

import com.dev.task_manager_backend.dto.TaskDTO;
import com.dev.task_manager_backend.modal.Task;
import com.dev.task_manager_backend.modal.User;
import com.dev.task_manager_backend.service.TaskService;
import com.dev.task_manager_backend.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Task", description = "The User API. Contains all the operations that can be performed on a task.")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

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
        return new ResponseEntity<>(taskService.addTask(taskDTO), HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO){
        return new ResponseEntity<>(taskService.updateTask(id, taskDTO), HttpStatus.OK);
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
