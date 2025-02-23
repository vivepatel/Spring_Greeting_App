package com.greetingapp.Spring_Greeting_App.Controller;

import com.greetingapp.Spring_Greeting_App.Controller.Greeting;
import com.greetingapp.Spring_Greeting_App.Controller.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    // Existing method to create a greeting
    public String getGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello " + lastName + "!";
        } else {
            message = "Hello World!";
        }

        // Save the greeting message to the repository
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);

        return message;
    }

    // New method to delete a greeting by ID
    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true; // Return true if the greeting was deleted
        }
        return false; // Return false if the greeting was not found
    }
}