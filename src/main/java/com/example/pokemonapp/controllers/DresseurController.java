package com.example.pokemonapp.controllers;

import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.services.DresseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dresseurs")
@CrossOrigin(origins = "http://localhost:4200")
public class DresseurController {

    @Autowired
    private DresseurService service;

    @GetMapping("/me")
    public ResponseEntity<Dresseur> getMe(Authentication authentication) {
        String username = authentication.getName();

        return service.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
