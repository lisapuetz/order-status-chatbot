package com.example.chatbot;

import com.example.chatbot.model.Order;
import org.springframework.core.io.ClassPathResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JsonDataService {
    private final ObjectMapper objectMapper;

    public JsonDataService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Order> readData() throws IOException {
        ClassPathResource resource = new ClassPathResource("orders.json");
        return objectMapper.readValue(resource.getInputStream(), objectMapper.getTypeFactory().constructCollectionType(List.class, Order.class));
    }


//    public Optional<String> getOrderStatusById(String id) {
//        try {
//            List<Order> orders = readData();
//            return orders.stream()
//                    .filter(obj -> Objects.equals(obj.getId(), id))
//                    .map(Order::getStatus)
//                    .findFirst();
//        } catch (IOException e) {
//            System.err.println("Error reading data: " + e.getMessage());
//            return Optional.empty();
//        }
//    }
}

