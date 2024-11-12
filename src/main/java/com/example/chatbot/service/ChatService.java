package com.example.chatbot.service;

import com.example.chatbot.handler.OrderIdentificationHandler;
import com.example.chatbot.handler.OrderStatusHandler;
import com.example.chatbot.model.ChatSession;
import com.example.chatbot.utils.TokenizerUtil;
import com.example.chatbot.view.ChatView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {
    private final OrderService orderService;
    private final ResponseService responseService;
    private final OrderIdentificationHandler orderIdentificationHandler;
    private final OrderStatusHandler orderStatusHandler;
    private final TokenizerUtil tokenizerUtil;
    private final ChatView view;

    @Autowired
    public ChatService(OrderService orderService,
                       ResponseService responseService,
                       OrderIdentificationHandler orderIdentificationHandler,
                       OrderStatusHandler orderStatusHandler,
                       TokenizerUtil tokenizerUtil,
                       ChatView view) {
        this.orderService = orderService;
        this.responseService = responseService;
        this.orderIdentificationHandler = orderIdentificationHandler;
        this.orderStatusHandler = orderStatusHandler;
        this.tokenizerUtil = tokenizerUtil;
        this.view = view;
    }

    public void startChat() {
        ChatSession chatSession = new ChatSession();
        view.displayResponse("Hello! Welcome to our order tracking service.");

        while (true) {
            orderIdentificationHandler.handleConversation(chatSession, view);
            if (chatSession.getCurrOrder() != null) { orderStatusHandler.handleConversation(chatSession, view); }

            view.displayResponse("Would you like to check on another order?");
            String userConfirmation = view.getUserInput();

            if (userConfirmation.trim().equalsIgnoreCase("no") ||
                    userConfirmation.trim().equalsIgnoreCase("end") ||
                    userConfirmation.trim().equalsIgnoreCase("exit")) {
                view.displayResponse("Okay, goodbye!");
                break;
            }
        }
        view.close();
    }
}