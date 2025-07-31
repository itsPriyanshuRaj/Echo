package com.raj.echo.user.service;

import org.springframework.stereotype.Service;

import com.raj.echo.user.dto.UserRequest;
import com.raj.echo.user.dto.UserResponse;
import com.raj.echo.user.model.User;

@Service
public interface UserService {
    User registerUser(UserRequest userRequest);
    UserResponse getUserByEmail(String email);
}
