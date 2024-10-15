package com.example.chatbot.models;

import java.util.*;

import opennlp.tools.tokenize.SimpleTokenizer;

public class Input extends Message {
    private TokenizerUtil tokenizerUtil;

    public Input() {
        this.tokenizerUtil = new TokenizerUtil();
    }

    public String processUserInput(String userInput) {
        String[] tokens = tokenizerUtil.tokenize(userInput);
        return identifyOrderNo(tokens);
    }

//    public String identifyIntent(String[] tokens) {
//        String intent = "";
//        for (String token : tokens) {
//            if (token.equalsIgnoreCase("policy")) {
//                intent = "FAQ";
//            } else if (token.equalsIgnoreCase("issue") || token.equalsIgnoreCase("problem")) {
//                intent = "ISSUE";
//            }
//        }
//        return intent;
//    }

    public String identifyOrderNo(String[] tokens) {
        Set<String> topics = new HashSet<>();
        for (String token : tokens) {
            if (token.matches("\\d{8}")) {
                return token;
            }
        }
        return null;
    }
}