package com.shelflife.bookstorereactspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User input) {
        Map<String, Object> response = new HashMap<>();

        if (userRepository.findByEmail(input.getEmail()).isPresent()) {
            response.put("success", false);
            response.put("message", "An account with that email already exists.");
            return response;
        }

        input.setPassword(encoder.encode(input.getPassword()));
        userRepository.save(input);

        response.put("success", true);
        response.put("message", "Account created successfully.");
        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User input) {
        Map<String, Object> response = new HashMap<>();

        var userOpt = userRepository.findByEmail(input.getEmail());
        if (userOpt.isEmpty() || !encoder.matches(input.getPassword(), userOpt.get().getPassword())) {
            response.put("success", false);
            response.put("message", "Invalid email or password.");
            return response;
        }

        User user = userOpt.get();
        response.put("success", true);
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        return response;
    }
}