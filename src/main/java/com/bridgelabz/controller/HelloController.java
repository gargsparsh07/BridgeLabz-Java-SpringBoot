package com.bridgelabz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    // UC1: curl localhost:8080/hello -w "\n"
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        logger.debug("UC1: sayHello called");
        return "Hello from BridgeLabz!!!";
    }

    // UC2: curl localhost:8080/hello/query?name=Mark -w "\n"
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String sayHelloWithQueryParam(@RequestParam(value = "name") String name) {
        logger.debug("UC2: sayHelloWithQueryParam called with name={}", name);
        return "Hello " + name + "!";
    }

    // UC3: curl localhost:8080/hello/param/Mark -w "\n"
    @GetMapping("/param/{name}")
    public String sayHelloWithPathVariable(@PathVariable String name) {
        logger.debug("UC3: sayHelloWithPathVariable called with name={}", name);
        return "Hello " + name + "!";
    }
}