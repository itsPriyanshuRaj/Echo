package com.raj.Echo.payment.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "payments")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {
     @Id
    private String id;

    private String orderId;
    private String userId;
    private double amount;
    private String status; // PENDING, SUCCESS, FAILED
    private LocalDateTime paymentTime;
    
}
