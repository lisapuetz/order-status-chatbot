package com.example.chatbot.controllers;

import com.example.chatbot.JsonDataService;
import com.example.chatbot.models.Input;
import com.example.chatbot.models.Response;
import com.example.chatbot.views.ChatView;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Optional;

public class ChatController {
    private Input input;
    private Response response;
    private ChatView view;
    private JsonDataService dataService;

    public ChatController() {
        this.input = new Input();
        this.response = new Response();
        this.view = new ChatView();
        this.dataService = new JsonDataService(new ObjectMapper());
    }

    public void startChat() {
        System.out.println("Hello!");
        while (true) {
            view.displayResponse("Please let me know the 8-digit order number that you'd like to check on. [for testing: 00000000, 11111111, 22222222, 33333333, 44444444, or 55555555]");
            String ui = input.processUserInput(view.getUserInput());
            Optional<String> orderStatus = dataService.getOrderStatusById(ui);
            String statusResponse = response.generateResponse(orderStatus);
            view.displayResponse(statusResponse);
            if (orderStatus.equals("noOrder") || orderStatus.isEmpty()) {
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