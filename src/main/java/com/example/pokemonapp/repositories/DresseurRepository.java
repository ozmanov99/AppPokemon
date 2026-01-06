package com.example.pokemonapp.repositories;

import com.example.pokemonapp.entities.Dresseur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DresseurRepository extends JpaRepository<Dresseur, Long> {
    Optional<Dresseur> findByUsername(String username);
}
