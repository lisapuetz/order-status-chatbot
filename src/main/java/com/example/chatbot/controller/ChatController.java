package com.example.chatbot.controller;

import com.example.chatbot.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatbotService;

    public ChatController(ChatService chatbotService) {
        this.chatbotService = chatbotService;
    }

    // Start the chat when a user hits this endpoint
    @PostMapping("/start")
    public void startChat() {
        chatbotService.startChat();
    }
}