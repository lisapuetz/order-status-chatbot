package com.example.chatbot.handler;

public interface ConversationFlow {
    void handleConversation(UserRequest userRequest, ChatSession chatSession);
}
