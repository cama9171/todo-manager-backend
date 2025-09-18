package com.dev.task_manager_backend.service;

import com.dev.task_manager_backend.modal.User;
import com.dev.task_manager_backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void addUser(User newUser) {
        userRepo.save(newUser);
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}
