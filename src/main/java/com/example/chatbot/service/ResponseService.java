package com.example.chatbot.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ResponseService {
    private Map<String, String> responses;

    public ResponseService() {
        responses = new HashMap<>();
        responses.put("noOrder", "I'm sorry, it doesn't look like that's a valid order number.");
        responses.put("pending", "Your order has been received, but not yet processed.");
        responses.put("processing", "This order is currently being packaged.");
        responses.put("shipped", "This order has been shipped and is currently on its way to you.");
        responses.put("delivered", "My records are showing that this order has been delivered to you.");
        responses.put("cancelled", "My records are showing that this order has been cancelled.");
        responses.put("returned", "My records are showing that this order has been returned.");
    }

    public String generateResponse(Optional<String> input) {
        if (input.isPresent()) {
            return responses.getOrDefault(input.get(), "I'm sorry, I'm having trouble finding an order with that order number.");
        }
        return "I'm sorry, I'm having trouble finding an order with that order number.";
    }
}
