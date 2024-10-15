package com.example.chatbot;

import com.example.chatbot.controllers.ChatController;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.chatbot.models.Input;
import com.example.chatbot.views.ChatView;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;


@SpringBootApplication
public class ChatbotApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ChatbotApplication.class, args);
		ChatController controller = new ChatController();

        controller.startChat();
    }

}