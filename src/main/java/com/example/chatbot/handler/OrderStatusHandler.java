package com.example.chatbot.handler;

@Component
public class OrderStatusHandler implements ConversationFlow {
    @Override
    public void handleConversation(UserRequest userRequest, ChatSession chatSession) {
        String orderNumber = userRequest.getOrderNumber();
        OrderStatus status = orderService.getOrderStatus(orderNumber);

        if (status != null) {
            chatSession.sendMessage("The status of your order " + orderNumber + " is: " + status);
            chatSession.ask("Would you like to check another order or exit?");
        } else {
            chatSession.sendMessage("Sorry, we couldn't find your order. Please try again.");
            chatSession.ask("Would you like to try another order number?");
        }
    }
}