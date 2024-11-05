package com.example.chatbot.model;

import java.util.Date;

public class Order {

    private String orderNumber;
    private String status;
    private String carrierTracking;
    private Date deliveryDate;

    //including statically typed id in constructor for testing purposes only
    public Order(String orderNumber, String status, String carrierTracking, Date deliveryDate) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.carrierTracking = carrierTracking;
        this.deliveryDate = deliveryDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
