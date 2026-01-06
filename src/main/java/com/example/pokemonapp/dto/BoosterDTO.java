package com.example.pokemonapp.dto;

import com.example.pokemonapp.entities.Pokemon;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BoosterDTO {
    private Long id;
    private LocalDate dateOuverture;
    private List<Pokemon> cartes;

    public BoosterDTO(Long id, LocalDate dateOuverture, List<Pokemon> cartes) {
        this.id = id;
        this.dateOuverture = dateOuverture;
        this.cartes = cartes;
    }
}
