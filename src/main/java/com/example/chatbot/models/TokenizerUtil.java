package com.example.chatbot.models;

import opennlp.tools.tokenize.SimpleTokenizer;

public class TokenizerUtil {
    private SimpleTokenizer tokenizer;

    public TokenizerUtil() {
        this.tokenizer = SimpleTokenizer.INSTANCE;
    }

    public String[] tokenize(String input) {
        return tokenizer.tokenize(input);
    }

}