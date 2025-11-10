package com.example.pokemonapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Booster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOuverture;

    @ManyToOne
    @JoinColumn(name = "dresseur_id")
    @JsonIgnore
    private Dresseur dresseur;

    @ManyToMany
    @JoinTable(
            name = "booster_pokemon",
            joinColumns = @JoinColumn(name = "booster_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    private List<Pokemon> cartes;
}
