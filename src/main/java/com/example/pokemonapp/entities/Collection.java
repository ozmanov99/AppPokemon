package com.example.pokemonapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dresseur_id")
    private Dresseur dresseur;

    @ManyToOne
    @JoinColumn(name = "carte_id")
    private Pokemon carte;
}
