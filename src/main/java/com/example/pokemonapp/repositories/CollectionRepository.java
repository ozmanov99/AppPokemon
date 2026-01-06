package com.example.pokemonapp.repositories;

import com.example.pokemonapp.entities.Collection;
import com.example.pokemonapp.entities.Dresseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    List<Collection> findByDresseur(Dresseur dresseur);
}
