package com.greetingapp.Spring_Greeting_App.Controller;

import com.greetingapp.Spring_Greeting_App.Controller.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // New endpoint to delete a greeting by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
        boolean isDeleted = greetingService.deleteGreeting(id);
        if (isDeleted) {
            return ResponseEntity.ok("Greeting with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}