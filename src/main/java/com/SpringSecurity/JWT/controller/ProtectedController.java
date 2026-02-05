package com.SpringSecurity.JWT.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProtectedController {

    @GetMapping("/hello")
    public String hello(Authentication auth) {

        String username = auth.getName();

        return "Hello " + username +
                " → JWT Protected API Working Successfully!";
    }
}
