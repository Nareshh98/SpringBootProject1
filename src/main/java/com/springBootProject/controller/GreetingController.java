package com.springBootProject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

   // @Value("${message}")
   // private String message;
    @GetMapping("/api/greeting")
    public String greetings() {
        return "message";
    } 
  
}