package com.example.demo.Repository;

import com.example.demo.DTO.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}