package com.example.chatbot.handler;

import com.example.chatbot.model.ChatSession;
import com.example.chatbot.model.Order;
import com.example.chatbot.service.OrderService;
import com.example.chatbot.utils.TokenizerUtil;
import com.example.chatbot.view.ChatView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class OrderIdentificationHandler implements ConversationFlow {
    @Autowired
    private OrderService orderService;
    @Autowired
    private TokenizerUtil tokenizerUtil;
    @Override
    public void handleConversation(ChatSession chatSession, ChatView view) {
        view.displayResponse("Please let me know the 8-digit order number that you'd like to check on.");
        String ui = view.getUserInput();
        Optional<Order> orderOpt = orderService.getOrderById(tokenizerUtil.identifyOrderNo(ui));
        if (orderOpt.isPresent()) {
            chatSession.setCurrOrder(orderOpt.get());
        } else {
            view.displayResponse("I'm sorry, I'm not seeing a valid order number.");
        }
    }
}