package com.greetingapp.Spring_Greeting_App.Controller;
import com.greetingapp.Spring_Greeting_App.Controller.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        String greetingMessage = greetingService.getGreeting(firstName, lastName);

        Map<String, String> response = new HashMap<>();
        response.put("message", greetingMessage);
        return response;
    }
}