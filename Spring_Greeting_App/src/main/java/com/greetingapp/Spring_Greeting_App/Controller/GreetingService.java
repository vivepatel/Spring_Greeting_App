package com.greetingapp.Spring_Greeting_App.Controller;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting() {
        return "Hello World";
    }
}