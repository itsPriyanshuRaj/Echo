package com.raj.Echo.payment.service;

import java.util.List;

import com.raj.Echo.payment.Dto.PaymentRequest;
import com.raj.Echo.payment.Dto.PaymentResponse;

public interface PaymentService {
    PaymentResponse makePayment(PaymentRequest request);
    PaymentResponse getPaymentById(String paymentId);
    List<PaymentResponse> getPaymentsByUserId(String userId);
}
