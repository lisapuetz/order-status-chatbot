package com.example.chatbot.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
public class Response extends Message {
    private String content;

    public Response(String content) {
        this.content = content;
    }

    public String getMessage() {
        return content;
    }

    public void setMessage(String content) {
        this.content = content;
    }

}