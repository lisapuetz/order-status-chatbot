package com.example.chatbot.utils;

import opennlp.tools.tokenize.SimpleTokenizer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class TokenizerUtil {
    private SimpleTokenizer tokenizer;

    public TokenizerUtil() {
        this.tokenizer = SimpleTokenizer.INSTANCE;
    }

    public String[] tokenize(String input) {
        return tokenizer.tokenize(input);
    }

    public String identifyOrderNo(String input) {
        String[] tokens = tokenize(input);
        Set<String> topics = new HashSet<>();
        for (String token : tokens) {
            if (token.matches("\\d{8}")) {
                return token;
            } else if (token.matches("#\\d{8}")) {
                return token.substring(1);
            } else if (token.matches("[a-zA-Z]*\\d{8}")) {
                return token.replaceAll("[^\\d]", "");
            }
        }
        return null;
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

}