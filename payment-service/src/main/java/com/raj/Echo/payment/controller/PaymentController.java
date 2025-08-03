package com.raj.Echo.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.Echo.payment.Dto.PaymentRequest;
import com.raj.Echo.payment.Dto.PaymentResponse;
import com.raj.Echo.payment.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/make")
    public PaymentResponse makePayment(@RequestBody PaymentRequest request) {
        return paymentService.makePayment(request);
    }

    @GetMapping("/user/{userId}")
    public List<PaymentResponse> getPaymentsByUser(@PathVariable String userId) {
        return paymentService.getPaymentsByUserId(userId);
    }
}
