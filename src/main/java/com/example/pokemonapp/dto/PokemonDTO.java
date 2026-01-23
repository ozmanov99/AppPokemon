package com.example.pokemonapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PokemonDTO {
    private Long id;
    private String nom;
    private String type;
    private int niveau;
    private int attaque;
    private int defense;
    private String rarete;
    private String imageUrl;
}
