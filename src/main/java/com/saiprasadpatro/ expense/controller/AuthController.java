package com.saiprasadpatro.expense.controller;

import com.saiprasadpatro.expense.model.User;
import com.saiprasadpatro.expense.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User created = authService.register(user);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,Object> req) {
        Long orgId = Long.valueOf(req.get("orgId").toString());
        String email = req.get("email").toString();
        String password = req.get("password").toString();
        String token = authService.login(orgId, email, password);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
