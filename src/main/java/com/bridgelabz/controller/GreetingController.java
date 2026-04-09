package com.bridgelabz.controller;

import com.bridgelabz.dto.GreetingDTO;
import com.bridgelabz.model.GreetingEntity;
import com.bridgelabz.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private GreetingService greetingService;

    // UC1: Simple GET - returns JSON
    @GetMapping
    public ResponseEntity<String> getGreeting() {
        logger.debug("UC1: getGreeting called");
        return ResponseEntity.ok("{\"message\": \"Hello from BridgeLabz Greeting App!\"}");
    }

    // UC2: Hello World from service layer
    @GetMapping("/hello")
    public ResponseEntity<String> getHelloWorld() {
        logger.debug("UC2: getHelloWorld called");
        return ResponseEntity.ok(greetingService.getGreetingMessage());
    }

    // UC3: Greeting with name
    @PostMapping("/name")
    public ResponseEntity<String> getGreetingWithName(@RequestBody GreetingDTO dto) {
        logger.debug("UC3: getGreetingWithName called");
        return ResponseEntity.ok(greetingService.getGreetingMessage(dto));
    }

    // UC4: Save greeting
    @PostMapping
    public ResponseEntity<GreetingEntity> saveGreeting(@RequestBody GreetingDTO dto) {
        logger.debug("UC4: saveGreeting called");
        return ResponseEntity.ok(greetingService.saveGreeting(dto));
    }
}