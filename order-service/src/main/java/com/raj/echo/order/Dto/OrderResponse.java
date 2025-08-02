package com.raj.echo.order.Dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderResponse {
    
    private String id;
    private String userId;
    private List<OrderItemRequest> items;
    private double totalAmount;
    private String status;
    private LocalDateTime orderDate;
}
