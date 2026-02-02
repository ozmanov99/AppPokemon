package com.example.pokemonapp.repositories;

import com.example.pokemonapp.entities.Collection;
import com.example.pokemonapp.entities.Dresseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {

    Page<Collection> findByDresseur(Dresseur dresseur, Pageable pageable);
    Optional<Collection> findFirstByCarteIdAndDresseur(Long carteId, Dresseur dresseur);
}
