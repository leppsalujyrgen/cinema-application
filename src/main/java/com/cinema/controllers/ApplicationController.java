package com.cinema.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.stereotype.Controller;

@Controller
public class ApplicationController {
	
	@GetMapping("/")
    public String home() {
        return "index";
    }
    
}
