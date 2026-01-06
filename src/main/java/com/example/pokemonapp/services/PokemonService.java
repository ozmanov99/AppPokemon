package com.example.pokemonapp.services;

import com.example.pokemonapp.entities.Pokemon;
import com.example.pokemonapp.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepo;

    public Pokemon ajouter(Pokemon p) {
        return pokemonRepo.save(p);
    }

    public List<Pokemon> lister() {
        return pokemonRepo.findAll();
    }

    public void supprimer(Long id) {

        pokemonRepo.deleteById(id);
    }

    public Optional<Pokemon> rechercher(Long id) {

        return pokemonRepo.findById(id);
    }
}



