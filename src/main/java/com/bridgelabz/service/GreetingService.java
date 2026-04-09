package com.bridgelabz.service;

import com.bridgelabz.dto.GreetingDTO;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    // UC2: Simple Hello World
    public String getGreetingMessage() {
        return "Hello World";
    }

    // UC3: Greeting with name
    public String getGreetingMessage(GreetingDTO dto) {
        if (dto.getFirstName() != null && dto.getLastName() != null)
            return "Hello " + dto.getFirstName() + " " + dto.getLastName();
        else if (dto.getFirstName() != null)
            return "Hello " + dto.getFirstName();
        else if (dto.getLastName() != null)
            return "Hello " + dto.getLastName();
        else
            return "Hello World";
    }
}