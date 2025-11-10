package com.example.pokemonapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;
    private int niveau;
    private int attaque;
    private int defense;
    private String rarete;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "dresseur_id")
    @JsonIgnore
    private Dresseur dresseur;
}
