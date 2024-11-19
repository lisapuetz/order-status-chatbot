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
        responses.put("STATUS_noOrder", "I'm sorry, it doesn't look like that's a valid order number.");
        responses.put("STATUS_pending", "Your order has been received, but not yet processed.");
        responses.put("STATUS_processing", "This order is currently being packaged.");
        responses.put("STATUS_shipped", "This order has been shipped and is currently on its way to you.");
        responses.put("STATUS_delivered", "My records are showing that this order has been delivered to you.");
        responses.put("STATUS_cancelled", "My records are showing that this order has been cancelled.");
        responses.put("STATUS_returned", "My records are showing that this order has been returned.");
        responses.put("CANCEL_noOrder", "I'm sorry, it doesn't look like that's a valid order number.");
        responses.put("CANCEL_success", "Your order cancellation has been successfully initiated. You should receive a confirmation email shortly.");
        responses.put("CANCEL_shipped", "This order has been shipped and is currently on its way to you, so we are unable to cancel it. Once you receive the order, you can initiate a return.");
        responses.put("CANCEL_delivered", "My records are showing that this order has been delivered to you, so we are unable to cancel it. You can initiate a return instead.");
        responses.put("CANCEL_cancelled", "My records are showing that this order has already been cancelled.");
        responses.put("CANCEL_returned", "My records are showing that this order has been returned, so we are unable to cancel it.");
    }

    public String generateResponse(Optional<String> input, String sourceContext) {
        if (input.isPresent()) {
            String modInput = sourceContext + "_" + input.get();
            return responses.getOrDefault(modInput, "I'm sorry, I'm having trouble finding an order with that order number.");
        }
        return "I'm sorry, I'm having trouble finding an order with that order number.";
    }
}