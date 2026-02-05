package com.SpringSecurity.JWT.controller;

import com.SpringSecurity.JWT.model.User;
import com.SpringSecurity.JWT.repository.UserRepository;
import com.SpringSecurity.JWT.Security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authManager;


    @PostMapping("/register")
    public String register(@RequestBody User user) {


        if (repo.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists!";
        }


        user.setPassword(encoder.encode(user.getPassword()));


        user.setRole("USER");

        repo.save(user);

        return "User Registered Successfully!";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        Authentication authentication =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getUsername(),
                                user.getPassword()
                        )
                );

        if (authentication.isAuthenticated()) {

            String token =
                    jwtService.generateToken(user.getUsername());

            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return response;
        }

        throw new BadCredentialsException("Invalid Credentials");
    }
}
