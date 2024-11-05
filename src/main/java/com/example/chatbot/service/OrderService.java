// Provides methods for accessing and modifying orders
package com.example.chatbot.service;

import com.example.chatbot.model.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {
    private final Map<String, Order> orders = new HashMap<>();

    public OrderService() {
        // pre-populated sample data
        orders.put("00000000", new Order("00000000","pending", null, null));
        orders.put("11111111", new Order("11111111","processing", null, null));
        orders.put("22222222", new Order("22222222","shipped", "UPS1234", new Date(2030,03,03)));
        orders.put("33333333", new Order("33333333","delivered", "UPS5678", new Date(2030,03,02)));
        orders.put("44444444", new Order("44444444","cancelled", null, null));
        orders.put("55555555", new Order("55555555","returned", "UPS1121", new Date(2030,03,03)));
    }

    public Optional<Order> getOrderById(String orderNumber) {
        return Optional.ofNullable(orders.get(orderNumber));
    }

    public Optional<String> getOrderStatus(String orderNumber) {
        Optional<Order> orderOpt = getOrderById(orderNumber);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            return Optional.ofNullable(order.getStatus());
        }
        return Optional.empty();
    }

    public boolean updateOrderStatus(String orderNumber, String newStatus) {
        Order order = orders.get(orderNumber);
        if (order != null) {
            order.setStatus(newStatus);
            return true;
        }
        return false;
    }

    public boolean addOrder(Order order) {
        if (!orders.containsKey(order.getOrderNumber())) {
            orders.put(order.getOrderNumber(), order);
            return true;
        }
        return false;
    }
}