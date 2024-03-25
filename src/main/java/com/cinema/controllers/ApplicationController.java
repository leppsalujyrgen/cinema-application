package com.cinema.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


@Controller
public class ApplicationController {
	
	@GetMapping("/")
    public String home() {
        return "index";
    }
    
}
