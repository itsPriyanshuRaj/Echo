package com.raj.echo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raj.echo.user.dto.UserRequest;
import com.raj.echo.user.model.User;
import com.raj.echo.user.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/regitser")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRequest userRequest){
        User createdUser = userService.registerUser(userRequest);
        return ResponseEntity.ok(createdUser);
    }
    

    @GetMapping("get")
    public ResponseEntity<User> getUserById(@Valid @PathVariable String id){
         User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    
}
