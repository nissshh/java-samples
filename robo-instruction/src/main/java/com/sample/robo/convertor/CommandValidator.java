package com.sample.robo.convertor;

import java.util.StringTokenizer;

public class CommandValidator {

    public boolean validate(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line);
        if (tokenizer.countTokens() != 2) {
            return false;
        }
        return true;
    }
}
