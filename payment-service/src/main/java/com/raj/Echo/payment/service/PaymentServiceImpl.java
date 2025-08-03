package com.raj.Echo.payment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.raj.Echo.payment.Dto.PaymentRequest;
import com.raj.Echo.payment.Dto.PaymentResponse;
import com.raj.Echo.payment.model.Payment;
import com.raj.Echo.payment.repo.PaymentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepo paymentRepo;
    @Override
    public PaymentResponse makePayment(PaymentRequest request) {
        Payment payment = Payment.builder()
                            .orderId(request.getOrderId())
                            .userId(request.getUserId())
                            .amount(request.getAmount())
                            .status("SUCCESS")
                            .paymentTime(LocalDateTime.now())
                            .build();
        Payment save = paymentRepo.save(payment);
        return mapToResponse(save);
    }

    @Override
    public PaymentResponse getPaymentById(String paymentId) {
        Payment payment = paymentRepo.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
        return mapToResponse(payment);
    }

    @Override
    public List<PaymentResponse> getPaymentsByUserId(String userId) {
       List<Payment> payments = paymentRepo.findByUserId(userId);
        return payments.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private PaymentResponse mapToResponse(Payment payment) {
    PaymentResponse response = new PaymentResponse();
    response.setPaymentId(payment.getId());
    response.setOrderId(payment.getOrderId());
    response.setUserId(payment.getUserId());
    response.setAmount(payment.getAmount());
    response.setStatus(payment.getStatus());
    response.setPaymentTime(payment.getPaymentTime());
    return response;
}



    
}
