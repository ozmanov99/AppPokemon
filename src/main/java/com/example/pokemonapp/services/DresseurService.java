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

    public Optional<Dresseur> findByUsername(String username) {
        return repository.findByUsername(username);
    }


}

