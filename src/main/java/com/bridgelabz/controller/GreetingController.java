package com.bridgelabz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    // UC1: Simple GET - returns JSON
    @GetMapping
    public ResponseEntity<String> getGreeting() {
        logger.debug("UC1: getGreeting called");
        return ResponseEntity.ok("{\"message\": \"Hello from BridgeLabz Greeting App!\"}");
    }
}