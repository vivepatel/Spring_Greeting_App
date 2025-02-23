package com.greetingapp.Spring_Greeting_App.Controller;

import com.greetingapp.Spring_Greeting_App.Controller.Greeting;
import com.greetingapp.Spring_Greeting_App.Controller.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

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
}