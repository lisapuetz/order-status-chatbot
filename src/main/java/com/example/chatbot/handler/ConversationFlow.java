package com.example.chatbot.handler;

import com.example.chatbot.model.ChatSession;
import com.example.chatbot.service.OrderService;
import com.example.chatbot.service.ResponseService;
import com.example.chatbot.utils.TokenizerUtil;
import com.example.chatbot.view.ChatView;
import org.springframework.beans.factory.annotation.Autowired;

public interface ConversationFlow {
    void handleConversation(ChatSession chatSession, ChatView view);
}
