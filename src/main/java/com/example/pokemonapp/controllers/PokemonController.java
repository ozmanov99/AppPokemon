package com.example.pokemonapp.controllers;

import com.example.pokemonapp.dto.PagedResponse;
import com.example.pokemonapp.dto.PokemonDTO;
import com.example.pokemonapp.entities.Collection;
import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.repositories.CollectionRepository;
import com.example.pokemonapp.repositories.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController {

    @Autowired
    private DresseurRepository dresseurRepo;

    @Autowired
    private CollectionRepository collectionRepo;

    /**
     * Récupérer les Pokémon du dresseur connecté avec pagination
     */
    @GetMapping("/pokemons")
    public PagedResponse<PokemonDTO> getMyPokemons(
            Authentication authentication,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        String username = authentication.getName();
        Dresseur d = dresseurRepo.findByUsername(username).orElseThrow();

        Pageable pageable = PageRequest.of(page, size);
        Page<Collection> mesCollections = collectionRepo.findByDresseur(d, pageable);

        List<PokemonDTO> pokemons = mesCollections.stream()
                .map(Collection::getCarte)
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
                .toList();

        return new PagedResponse<>(
                pokemons,
                mesCollections.getNumber(),
                mesCollections.getSize(),
                mesCollections.getTotalElements(),
                mesCollections.getTotalPages()
        );
    }

    /**
     * Supprimer UN SEUL Pokémon (une seule carte) du dresseur connecté
     */
    @DeleteMapping("/pokemons/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id, Authentication authentication) {

        String username = authentication.getName();
        Dresseur d = dresseurRepo.findByUsername(username).orElseThrow();

        Collection carte = collectionRepo
                .findFirstByCarteIdAndDresseur(id, d)
                .orElseThrow(() -> new RuntimeException("Ce Pokémon n'est pas dans ta collection"));

        collectionRepo.delete(carte);

        return ResponseEntity.noContent().build();
    }
}
