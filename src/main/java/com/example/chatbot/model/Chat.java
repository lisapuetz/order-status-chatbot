package com.example.chatbot.model;

import java.util.List;
//context management
public class Chat {
    private String id;
    private String lastIntent;
    private List<Message> previousMessages;
    private boolean isConfirming;

    public Chat() {
        isConfirming = false;
    }

    public String getLastIntent() {
        return lastIntent;
    }

    public void setLastIntent(String lastIntent) {
        this.lastIntent = lastIntent;
    }

    public List<Message> getPreviousMessages() {
        return previousMessages;
    }
}
