package com.greetingapp.Spring_Greeting_App.Controller;

import com.greetingapp.Spring_Greeting_App.Controller.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
