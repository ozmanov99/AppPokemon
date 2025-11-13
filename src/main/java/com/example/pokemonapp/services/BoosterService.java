package com.example.pokemonapp.services;

import com.example.pokemonapp.dto.BoosterDTO;
import com.example.pokemonapp.entities.Booster;
import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.entities.Pokemon;
import com.example.pokemonapp.repositories.BoosterRepository;
import com.example.pokemonapp.repositories.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoosterService {

    @Autowired
    private BoosterRepository boosterRepo;

    @Autowired
    private DresseurRepository dresseurRepo;

    /**
     * Ouvre un booster pour un dresseur (prend le premier booster disponible)
     * Tire 5 cartes aléatoires du booster.
     */
    public BoosterDTO ouvrirBooster(Long dresseurId) {
        Dresseur dresseur = dresseurRepo.findById(dresseurId)
                .orElseThrow(() -> new RuntimeException("Dresseur introuvable"));

        Booster booster = boosterRepo.findAll().stream()
                .filter(b -> b.getDresseur().getId().equals(dresseurId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun booster disponible pour ce dresseur"));

        List<Pokemon> cartes = booster.getCartes();
        if (cartes == null || cartes.isEmpty()) {
            throw new RuntimeException("Aucune carte disponible dans ce booster");
        }

        // Mélange et tirage aléatoire de 5 cartes
        Collections.shuffle(cartes);
        List<Pokemon> cartesAleatoires = cartes.stream()
                .limit(5)
                .collect(Collectors.toList());

        return new BoosterDTO(booster.getId(), booster.getDateOuverture(), cartesAleatoires);
    }

    /**
     * Ouvre un booster d’un type spécifique pour un dresseur.
     * Tire 5 cartes aléatoires du booster correspondant.
     */
    public BoosterDTO ouvrirBoosterParType(Long dresseurId, String type) {
        Dresseur dresseur = dresseurRepo.findById(dresseurId)
                .orElseThrow(() -> new RuntimeException("Dresseur introuvable"));

        Booster booster = boosterRepo.findAll().stream()
                .filter(b -> b.getDresseur().getId().equals(dresseurId)
                        && b.getCartes() != null
                        && !b.getCartes().isEmpty()
                        && b.getCartes().get(0).getType().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun booster de type " + type + " trouvé"));

        List<Pokemon> cartes = booster.getCartes();
        if (cartes == null || cartes.isEmpty()) {
            throw new RuntimeException("Aucune carte disponible dans ce booster de type " + type);
        }

        // Mélange et tirage aléatoire de 5 cartes
        Collections.shuffle(cartes);
        List<Pokemon> cartesAleatoires = cartes.stream()
                .limit(5)
                .collect(Collectors.toList());

        return new BoosterDTO(booster.getId(), booster.getDateOuverture(), cartesAleatoires);
    }

    /**
     * Liste tous les boosters sous forme de DTO.
     */
    public List<BoosterDTO> lister() {
        return boosterRepo.findAll().stream()
                .map(b -> new BoosterDTO(b.getId(), b.getDateOuverture(), b.getCartes()))
                .collect(Collectors.toList());
    }
}
