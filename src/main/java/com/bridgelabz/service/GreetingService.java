package com.bridgelabz.service;

import com.bridgelabz.dto.GreetingDTO;
import com.bridgelabz.model.GreetingEntity;
import com.bridgelabz.repository.IGreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private IGreetingRepo greetingRepo;

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

    // UC4: Save greeting
    public GreetingEntity saveGreeting(GreetingDTO dto) {
        GreetingEntity entity = new GreetingEntity();
        entity.setMessage(getGreetingMessage(dto));
        return greetingRepo.save(entity);
    }

    // UC5: Find by ID
    public Optional<GreetingEntity> findGreetingById(Long id) {
        return greetingRepo.findById(id);
    }
}