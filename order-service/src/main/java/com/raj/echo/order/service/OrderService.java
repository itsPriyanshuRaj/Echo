package com.raj.echo.order.service;

import java.util.List;

import com.raj.echo.order.Dto.OrderRequest;
import com.raj.echo.order.Dto.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);
    OrderResponse getOrderById(String orderId);
    List<OrderResponse> getOrdersByUser(String userId);
}
