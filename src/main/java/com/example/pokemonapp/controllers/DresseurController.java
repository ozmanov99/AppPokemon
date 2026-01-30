package com.example.pokemonapp.controllers;

import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.services.DresseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dresseurs")
@CrossOrigin(origins = "http://localhost:4200")
public class DresseurController {

    @Autowired
    private DresseurService service;

    // Seul l'admin peut lister tous les dresseurs
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Dresseur> getAll() {
        return service.lister();
    }

    // Chaque dresseur peut voir son propre profil ou admin peut voir n’importe qui
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or principal.username == @dresseurService.rechercher(#id).orElse(null)?.username")
    public ResponseEntity<Dresseur> get(@PathVariable Long id) {
        return service.rechercher(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un dresseur (seul admin pour créer manuellement, sinon register via AuthController)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Dresseur creer(@RequestBody Dresseur d) {
        return service.sauvegarder(d);
    }

    // Modifier un dresseur : admin ou le dresseur lui-même
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or principal.username == @dresseurService.rechercher(#id).orElse(null)?.username")
    public ResponseEntity<Dresseur> modifier(@PathVariable Long id, @RequestBody Dresseur d) {
        return service.rechercher(id)
                .map(existing -> {
                    d.setId(id);
                    return ResponseEntity.ok(service.sauvegarder(d));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer : seulement l'admin
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
