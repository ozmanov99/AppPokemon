package com.example.pokemonapp.controllers;

import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.services.DresseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dresseurs")
@CrossOrigin(origins = "http://localhost:4200")
public class DresseurController {

    @Autowired
    private DresseurService service;

    @GetMapping
    public List<Dresseur> getAll() {
        return service.lister();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dresseur> get(@PathVariable Long id) {
        return service.rechercher(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dresseur creer(@RequestBody Dresseur d) {
        return service.sauvegarder(d);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dresseur> modifier(@PathVariable Long id, @RequestBody Dresseur d) {
        return service.rechercher(id)
                .map(existing -> {
                    d.setId(id);
                    return ResponseEntity.ok(service.sauvegarder(d));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
