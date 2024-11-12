package com.example.chatbot.config;

import com.example.chatbot.handler.OrderIdentificationHandler;
import com.example.chatbot.handler.OrderStatusHandler;
import com.example.chatbot.service.ChatService;
import com.example.chatbot.service.OrderService;
import com.example.chatbot.service.ResponseService;
import com.example.chatbot.utils.TokenizerUtil;
import com.example.chatbot.view.ChatView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {

    @Bean
    public ChatService chatService(OrderService orderService,
                                   ResponseService responseService,
                                   OrderIdentificationHandler orderIdentificationHandler,
                                   OrderStatusHandler orderStatusHandler,
                                   TokenizerUtil tokenizerUtil,
                                   ChatView chatView) {
        return new ChatService(orderService, responseService, orderIdentificationHandler, orderStatusHandler, tokenizerUtil, chatView);
    }

    @Bean
    public OrderService orderService() {
        return new OrderService();
    }

    @Bean
    public ResponseService responseService() {
        return new ResponseService();
    }

    @Bean
    public OrderStatusHandler orderStatusHandler() {
        return new OrderStatusHandler();
    }

    @Bean
    public TokenizerUtil tokenizerUtil() {
        return new TokenizerUtil();
    }

    @Bean
    public ChatView chatView() {
        return new ChatView();
    }
}
