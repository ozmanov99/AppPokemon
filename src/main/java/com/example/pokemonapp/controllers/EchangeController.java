package com.example.pokemonapp.controllers;

import com.example.pokemonapp.entities.Echange;
import com.example.pokemonapp.services.EchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/echanges")
@CrossOrigin(origins = "http://localhost:4200")
public class EchangeController {
    @Autowired
    private EchangeService service;

    @GetMapping
    public List<Echange> getAll() {
        return service.lister();
    }

    @PostMapping
    public Echange proposer(@RequestBody Echange e) {
        return service.proposer(e);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Echange> get(@PathVariable Long id) {
        return service.rechercher(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/accepter")
    public ResponseEntity<Echange> accepter(@PathVariable Long id, @RequestBody Long dresseurId) {
        Echange e = service.accepter(id, dresseurId);
        return e != null ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/refuser")
    public ResponseEntity<Echange> refuser(@PathVariable Long id) {
        Echange e = service.refuser(id);
        return e != null ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }
}

