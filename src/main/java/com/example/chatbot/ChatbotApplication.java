package com.example.chatbot;

import com.example.chatbot.controller.ChatController;
import com.example.chatbot.service.ChatService;
import com.example.chatbot.service.OrderService;
import com.example.chatbot.service.ResponseService;
import com.example.chatbot.view.ChatView;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ChatbotApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ChatbotApplication.class, args);
        ChatService chatService = new ChatService(new OrderService(), new ResponseService(), new ChatView());

        chatService.startChat();
    }

}