package com.example.pokemonapp.repositories;

import com.example.pokemonapp.entities.Echange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchangeRepository extends JpaRepository<Echange, Long> {
}
