package com.raj.echo.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.raj.echo.order.Model.Order;

public interface OrderRepo extends MongoRepository<Order, String>{
    
}
