package com.dev.task_manager_backend.service;

import com.dev.task_manager_backend.modal.User;
import com.dev.task_manager_backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public User registerUser(User newUser) {
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        return userRepo.save(newUser);
    }

    public String verifyUser(User user) {
        Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authenticate.isAuthenticated()){
            String token = jwtService.generateToken(user.getUsername());
            return "{ \"token\": \"" + token + "\" }";
        }
        return "{ \"token\": \"Fail\" }";
    }
}
