package com.raj.echo.user.service;

import com.raj.echo.user.dto.UserRequest;
import com.raj.echo.user.model.User;

public interface UserService {
    User registerUser(UserRequest userRequest);
    User getUserById(String id);
}
