package com.example.chatbot;

import com.example.chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ChatbotApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private ChatService chatService;
	public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        chatService.startChat();
        SpringApplication.exit(context);
    }

}