package com.example.pokemonapp.controllers;

import com.example.pokemonapp.dto.BoosterDTO;
import com.example.pokemonapp.services.BoosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boosters")
@CrossOrigin(origins = "http://localhost:4200")
public class BoosterController {

    @Autowired
    private BoosterService boosterService;

    /**
     * Ouvrir un booster par type pour l’utilisateur connecté.
     * Les cartes tirées sont automatiquement ajoutées dans sa collection.
     */
    @PostMapping("/ouvrir/type/{type}")
    public BoosterDTO ouvrirParType(@PathVariable String type, Authentication auth) {
        String username = auth.getName(); // récupère le dresseur connecté via JWT
        return boosterService.ouvrirBoosterParTypePourUsername(type, username);
    }

    /**
     * Lister tous les boosters disponibles (génériques)
     */
    @GetMapping
    public List<BoosterDTO> getAll() {
        return boosterService.lister();
    }
}
