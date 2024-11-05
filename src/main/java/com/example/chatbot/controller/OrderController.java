package com.example.chatbot.controller;

import com.example.chatbot.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.chatbot.service.OrderService;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable String id, @RequestBody String newStatus) {
        boolean success = orderService.updateOrderStatus(id, newStatus);
        return success ? ResponseEntity.ok("Order status updated.") : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> addNewOrder(@RequestBody Order newOrder) {
        boolean success = orderService.addOrder(newOrder);
        return success ? ResponseEntity.status(HttpStatus.CREATED).body("Order created successfully.") :
                ResponseEntity.status(HttpStatus.CONFLICT).body("Order with this ID already exists.");
    }
}
