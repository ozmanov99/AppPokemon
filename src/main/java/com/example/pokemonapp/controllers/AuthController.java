package com.example.pokemonapp.controllers;

import com.example.pokemonapp.repositories.DresseurRepository;
import com.example.pokemonapp.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private DresseurRepository dresseurRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // Générer le token JWT
        return jwtUtils.generateToken(username);
    }
}
