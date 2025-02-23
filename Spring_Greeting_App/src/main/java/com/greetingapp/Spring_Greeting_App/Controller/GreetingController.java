package com.greetingapp.Spring_Greeting_App.Controller;

import com.greetingapp.Spring_Greeting_App.Controller.Greeting;
import com.greetingapp.Spring_Greeting_App.Controller.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Existing endpoint to create a greeting
    @GetMapping
    public String getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getGreeting(firstName, lastName);
    }

    // New endpoint to update a greeting
    @PutMapping("/{id}")
    public ResponseEntity<Greeting> updateGreeting(
            @PathVariable Long id,
            @RequestParam String newMessage) {
        Optional<Greeting> updatedGreeting = greetingService.updateGreeting(id, newMessage);
        return updatedGreeting.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}