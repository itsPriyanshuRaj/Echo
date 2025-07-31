package com.raj.echo.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.raj.echo.user.dto.UserRequest;
import com.raj.echo.user.dto.UserResponse;
import com.raj.echo.user.exception.UserNotFoundException;
import com.raj.echo.user.model.User;
import com.raj.echo.user.repo.UserRepo;

@Service
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
    public UserResponse getUserByEmail(String email){
        User user = userRepo.findByEmail(email)
            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + email));

        UserResponse response = new UserResponse();
        response.setEmail(user.getEmail());
        response.setUsername(user.getName());
        response.setRole(user.getRole());

        return response;
    }
    
}
