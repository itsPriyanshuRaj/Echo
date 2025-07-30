package com.raj.echo.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.raj.echo.user.dto.UserRequest;
import com.raj.echo.user.model.User;
import com.raj.echo.user.repo.UserRepo;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public User registerUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPass(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        user.setRole("ROLE_USER");
        return userRepo.save(user);
    }

    @Override
    public User getUserById(String id) {
       Optional<User> user = userRepo.findById(id);
       return user.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    
}
