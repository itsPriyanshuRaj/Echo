package com.raj.echo.user.repo;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.raj.echo.user.model.User;

public interface UserRepo extends MongoRepository<User,String>{
    Optional<User> findByEmail(String email);
}
