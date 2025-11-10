package com.example.pokemonapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
public class Dresseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String pseudo;
    private int niveau;
    private String role;

    private String username;
    private String password;

    @OneToMany(mappedBy = "dresseur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pokemon> pokemons;

    @OneToMany(mappedBy = "dresseur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booster> boosters;

}
