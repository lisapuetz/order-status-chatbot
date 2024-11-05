package com.example.chatbot.model;

import java.util.Date;

public abstract class Message {

    private String id;
    private Date timestamp;
    private String content;
    //status

    public String getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}