package com.raj.echo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.echo.user.dto.UserRequest;
import com.raj.echo.user.model.User;
import com.raj.echo.user.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello from user-service";
    }
    

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRequest userRequest){
        User createdUser = userService.registerUser(userRequest);
        return ResponseEntity.ok(createdUser);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@Valid @PathVariable String id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getUsersByEmail/{email}")
    public ResponseEntity<User> getUsers(@Valid @PathVariable String email){
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }
    
}
