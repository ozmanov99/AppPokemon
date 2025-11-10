package com.example.pokemonapp.services;

import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.repositories.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DresseurService {

    @Autowired
    private DresseurRepository repository;

    public List<Dresseur> lister() {
        return repository.findAll();
    }

    public Optional<Dresseur> rechercher(Long id) {
        return repository.findById(id);
    }

    public Dresseur sauvegarder(Dresseur dresseur) {
        return repository.save(dresseur);
    }

    public void supprimer(Long id) {
        repository.findById(id).ifPresent(dresseur -> {
            if (dresseur.getPokemons() != null) {
                dresseur.getPokemons().clear();
            }
            if (dresseur.getBoosters() != null) {
                dresseur.getBoosters().clear();
            }
            repository.delete(dresseur);
        });
    }
}

