package com.raj.Echo.payment.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.raj.Echo.payment.model.Payment;


public interface PaymentRepo  extends  MongoRepository<Payment, String>{
    List<Payment> findByUserId(String userId);
}
