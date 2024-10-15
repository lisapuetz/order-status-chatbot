package com.example.chatbot.views;

import java.util.Scanner;

public class ChatView {
    private Scanner scanner;

    public ChatView() {
        scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        System.out.print("You: ");
        return scanner.nextLine();
    }

    public void displayResponse(String response) {
        System.out.println("Bot: " + response);
    }

    public void close() {
        scanner.close();
    }
}
