package com.ddgroup.h3monitor.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {

    @GetMapping("/hello")
    public String hello() {
        return "Service Works!";
    }
}
