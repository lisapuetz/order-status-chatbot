package com.example.chatbot.service;

import com.example.chatbot.view.ChatView;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {

    private final OrderService orderService;
    private final ResponseService responseService;
    private final ChatView view;

    // Constructor-based dependency injection of OrderService and ResponseService
    public ChatService(OrderService orderService, ResponseService responseService, ChatView view) {
        this.orderService = orderService;
        this.responseService = responseService;
        this.view = view;
    }

    public void startChat() {
        view.displayResponse("Hello! Welcome to our order tracking service.");

        while (true) {
            view.displayResponse("Please let me know the 8-digit order number that you'd like to check on.");
            String ui = view.getUserInput();
            Optional<String> orderStatus = orderService.getOrderStatus(ui); // fetch order status

            String statusResponse = responseService.generateResponse(orderStatus);
            view.displayResponse(statusResponse);

            if (orderStatus.equals(Optional.empty()) || orderStatus.get().equals("noOrder")) {
                view.displayResponse("Would you like to try again?");
            } else {
                view.displayResponse("Would you like to check on another order?");
            }

            String userConfirmation = view.getUserInput();
            if (userConfirmation.trim().equalsIgnoreCase("no")) {
                view.displayResponse("Okay, goodbye!");
                break;
            }
        }

        view.close();
    }
}