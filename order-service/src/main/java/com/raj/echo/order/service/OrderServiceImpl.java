package com.raj.echo.order.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.echo.order.Dto.OrderItemRequest;
import com.raj.echo.order.Dto.OrderRequest;
import com.raj.echo.order.Dto.OrderResponse;
import com.raj.echo.order.Model.Order;
import com.raj.echo.order.Model.OrderItem;
import com.raj.echo.order.repo.OrderRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class OrderServiceImpl implements OrderService{

    // @Autowired
    private final OrderRepo orderRepo;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        List<OrderItem> items = request.getItems().stream()
                .map(i -> new OrderItem(i.getProductId(), i.getQuantity()))
                .collect(Collectors.toList());

        double totalAmount = 0; // You can calculate actual total after fetching product prices if needed.

        Order order = Order.builder()
                .userId(request.getUserId())
                .items(items)
                .status("PENDING")
                .totalAmount(totalAmount)
                .orderDate(LocalDateTime.now())
                .build();

        Order saved = orderRepo.save(order);

        return mapToResponse(saved);
    }

    @Override
    public OrderResponse getOrderById(String orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        return mapToResponse(order);
    }

    @Override
    public List<OrderResponse> getOrdersByUser(String userId) {
        return orderRepo.findAll().stream()
                .filter(o -> o.getUserId().equals(userId))
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private OrderResponse mapToResponse(Order order) {
        List<OrderItemRequest> items = order.getItems().stream()
                .map(i -> new OrderItemRequest(i.getProductId(), i.getQuantity()))
                .collect(Collectors.toList());

        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .items(items)
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus())
                .orderDate(order.getOrderDate())
                .build();
    }
}
