package com.example.salonbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/customers")
    public String customers() {
        return "customers";
    }
    
    @GetMapping("/services")
    public String services() {
        return "services";
    }
    
    @GetMapping("/bookings")
    public String bookings() {
        return "bookings";
    }
    
    @GetMapping("/new-booking")
    public String newBooking() {
        return "new-booking";
    }

}
