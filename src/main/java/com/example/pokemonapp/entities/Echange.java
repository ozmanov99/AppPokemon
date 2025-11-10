package com.example.pokemonapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Echange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "dresseur1_id")
    private Dresseur dresseur1;

    @ManyToOne
    @JoinColumn(name = "dresseur2_id")
    private Dresseur dresseur2;

    @ManyToMany
    @JoinTable(
            name = "echange_cartes_dresseur1",
            joinColumns = @JoinColumn(name = "echange_id"),
            inverseJoinColumns = @JoinColumn(name = "carte_id")
    )
    private List<Pokemon> cartesDresseur1;

    @ManyToMany
    @JoinTable(
            name = "echange_cartes_dresseur2",
            joinColumns = @JoinColumn(name = "echange_id"),
            inverseJoinColumns = @JoinColumn(name = "carte_id")
    )
    private List<Pokemon> cartesDresseur2;
}
