package com.bridgelabz.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    // UC2: Simple Hello World
    public String getGreetingMessage() {
        return "Hello World";
    }
}