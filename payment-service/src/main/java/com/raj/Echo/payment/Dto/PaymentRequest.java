package com.raj.Echo.payment.Dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private String orderId;
    private String userId;
    private double amount;
}
