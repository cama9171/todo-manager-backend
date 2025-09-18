package com.dev.task_manager_backend.service;

import com.dev.task_manager_backend.modal.User;
import com.dev.task_manager_backend.modal.UserPrinciple;
import com.dev.task_manager_backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TaskUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null){
            System.out.println("User not found!");
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserPrinciple(user);
    }
}
