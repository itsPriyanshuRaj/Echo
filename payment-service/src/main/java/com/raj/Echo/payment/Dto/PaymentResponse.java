package com.raj.Echo.payment.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private String paymentId;
    private String orderId;
    private String userId;
    private double amount;
    private String status;
    private LocalDateTime paymentTime;
}
