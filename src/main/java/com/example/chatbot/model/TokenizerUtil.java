package com.example.chatbot.model;

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