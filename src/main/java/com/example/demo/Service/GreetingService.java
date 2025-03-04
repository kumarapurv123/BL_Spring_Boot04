package com.example.demo.Service;


import com.example.demo.DTO.Greeting;
import com.example.demo.Repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public String getGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "{\"message\": \"Hello, " + firstName + " " + lastName + "!\"}";
        } else if (firstName != null) {
            return "{\"message\": \"Hello, " + firstName + "!\"}";
        } else if (lastName != null) {
            return "{\"message\": \"Hello, " + lastName + "!\"}";
        } else {
            return "{\"message\": \"Hello, World!\"}";
        }
    }
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public String createGreeting() {
        return "{\"message\": \"Greeting Created!\"}";
    }

    public String updateGreeting() {
        return "{\"message\": \"Greeting Updated!\"}";
    }

    public String deleteGreeting() {
        return "{\"message\": \"Greeting Deleted!\"}";
    }
}