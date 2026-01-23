package com.example.pokemonapp.controllers;

import com.example.pokemonapp.dto.PokemonDTO;
import com.example.pokemonapp.entities.Collection;
import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.entities.Pokemon;
import com.example.pokemonapp.repositories.CollectionRepository;
import com.example.pokemonapp.repositories.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController {

    @Autowired
    private DresseurRepository dresseurRepo;

    @Autowired
    private CollectionRepository collectionRepo;

    @GetMapping("/pokemons")
    public List<PokemonDTO> getMyPokemons(Authentication authentication) {
        String username = authentication.getName();
        Dresseur d = dresseurRepo.findByUsername(username).orElseThrow();

        List<Pokemon> mesPokemons = collectionRepo.findByDresseur(d).stream()
                .map(Collection::getCarte)
                .collect(Collectors.toList());

        // Inclure l'ID dans le DTO
        return mesPokemons.stream()
                .map(p -> new PokemonDTO(
                        p.getId(),
                        p.getNom(),
                        p.getType(),
                        p.getNiveau(),
                        p.getAttaque(),
                        p.getDefense(),
                        p.getRarete(),
                        p.getImageUrl()
                ))
                .collect(Collectors.toList());
    }


    @DeleteMapping("/pokemons/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id, Authentication authentication) {
        String username = authentication.getName();
        Dresseur d = dresseurRepo.findByUsername(username).orElseThrow();

        collectionRepo.deleteByCarteIdAndDresseur(id, d);
        return ResponseEntity.noContent().build();
    }

}
