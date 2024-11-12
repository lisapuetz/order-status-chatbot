package com.example.chatbot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

//context management
@Entity
public class ChatSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String currIntent;
    private Order currOrder;

    public UUID getId() {
        return id;
    }

    public String getCurrIntent() {
        return currIntent;
    }

    public void setCurrIntent(String currIntent) {
        this.currIntent = currIntent;
    }

    public Order getCurrOrder() {
        return currOrder;
    }

    public void setCurrOrder(Order currOrder) {
        this.currOrder = currOrder;
    }
}
