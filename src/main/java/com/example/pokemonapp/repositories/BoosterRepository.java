package com.example.pokemonapp.repositories;

import com.example.pokemonapp.entities.Booster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoosterRepository extends JpaRepository<Booster, Long> {
}
