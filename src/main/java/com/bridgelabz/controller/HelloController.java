package com.bridgelabz.controller;

import com.bridgelabz.dto.UserDTO;
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

    // UC4: curl -X POST -H "Content-Type: application/json"
    //      -d '{"firstName": "Mark","lastName": "Taylor"}'
    //      "http://localhost:8080/hello/post" -w "\n"
    @PostMapping("/post")
    public String sayHelloWithBody(@RequestBody UserDTO user) {
        logger.debug("UC4: sayHelloWithBody called with {} {}", user.getFirstName(), user.getLastName());
        return "Hello " + user.getFirstName() + " " + user.getLastName() + "!";
    }

    // UC5: curl -X PUT localhost:8080/hello/put/Mark?lastName=Taylor -w "\n"
    @PutMapping("/put/{firstName}")
    public String sayHelloWithPut(
            @PathVariable String firstName,
            @RequestParam(value = "lastName") String lastName) {
        logger.debug("UC5: sayHelloWithPut called with {}, {}", firstName, lastName);
        return "Hello " + firstName + " " + lastName + "!";
    }
}