package com.example.pokemonapp.repositories;

import com.example.pokemonapp.entities.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
}
