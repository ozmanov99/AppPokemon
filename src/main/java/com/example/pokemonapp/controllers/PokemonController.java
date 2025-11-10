package com.example.pokemonapp.controllers;

import com.example.pokemonapp.entities.Pokemon;
import com.example.pokemonapp.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemons")
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> getAll() {
        return pokemonService.lister(); }

    @PostMapping
    public Pokemon addPokemon(@RequestBody Pokemon p) {
        return pokemonService.ajouter(p); }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable Long id) {
        return pokemonService.rechercher(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
        if (pokemonService.rechercher(id).isPresent()) {
            pokemonService.supprimer(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
