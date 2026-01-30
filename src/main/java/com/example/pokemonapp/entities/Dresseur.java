package com.example.pokemonapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dresseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String pseudo;
    private int niveau;

    private String username;
    private String password;

    private String role = "DRESSEUR"; // Par défaut Dresseur

    private String photoUrl;

    @OneToMany(mappedBy = "dresseur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pokemon> pokemons;

    @OneToMany(mappedBy = "dresseur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booster> boosters;
}
