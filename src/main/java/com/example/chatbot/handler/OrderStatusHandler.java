package com.example.chatbot.handler;

import com.example.chatbot.model.ChatSession;
import com.example.chatbot.service.OrderService;
import com.example.chatbot.service.ResponseService;
import com.example.chatbot.view.ChatView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderStatusHandler implements ConversationFlow {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ResponseService responseService;
    @Override
    public void handleConversation(ChatSession chatSession, ChatView view) {
        Optional<String> orderStatus = orderService.getOrderStatus(chatSession.getCurrOrder());
        String statusResponse = responseService.generateResponse(orderStatus, "STATUS");
        view.displayResponse(statusResponse);
    }
}