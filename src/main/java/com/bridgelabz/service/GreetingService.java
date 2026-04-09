package com.bridgelabz.service;

import com.bridgelabz.dto.GreetingDTO;
import com.bridgelabz.model.GreetingEntity;
import com.bridgelabz.repository.IGreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    // UC6: List all
    public List<GreetingEntity> listAllGreetings() {
        return greetingRepo.findAll();
    }

    // UC7: Edit greeting
    public GreetingEntity editGreeting(Long id, GreetingDTO dto) {
        GreetingEntity entity = greetingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
        entity.setMessage(getGreetingMessage(dto));
        return greetingRepo.save(entity);
    }

    // UC8: Delete greeting
    public String deleteGreeting(Long id) {
        greetingRepo.deleteById(id);
        return "Greeting with id " + id + " deleted successfully";
    }
}