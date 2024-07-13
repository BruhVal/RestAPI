package com.example.RestAPI.controller;

import com.example.RestAPI.user.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public String login(@RequestBody User user) {
        if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }
    }
}
