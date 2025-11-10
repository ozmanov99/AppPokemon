package com.example.pokemonapp.services;

import com.example.pokemonapp.dto.BoosterDTO;
import com.example.pokemonapp.entities.Booster;
import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.repositories.BoosterRepository;
import com.example.pokemonapp.repositories.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoosterService {

    @Autowired
    private BoosterRepository boosterRepo;

    @Autowired
    private DresseurRepository dresseurRepo;

    // Ouvrir un booster pour un dresseur (prend le premier booster disponible)
    public BoosterDTO ouvrirBooster(Long dresseurId) {
        Dresseur dresseur = dresseurRepo.findById(dresseurId)
                .orElseThrow(() -> new RuntimeException("Dresseur introuvable"));

        Booster booster = boosterRepo.findAll().stream()
                .filter(b -> b.getDresseur().getId().equals(dresseurId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun booster disponible pour ce dresseur"));

        return new BoosterDTO(booster.getId(), booster.getDateOuverture(), booster.getCartes());
    }

    // Ouvrir un booster par type pour un dresseur
    public BoosterDTO ouvrirBoosterParType(Long dresseurId, String type) {
        Dresseur dresseur = dresseurRepo.findById(dresseurId)
                .orElseThrow(() -> new RuntimeException("Dresseur introuvable"));

        Booster booster = boosterRepo.findAll().stream()
                .filter(b -> b.getDresseur().getId().equals(dresseurId) &&
                        b.getCartes().get(0).getType().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun booster de type " + type + " trouvé"));

        return new BoosterDTO(booster.getId(), booster.getDateOuverture(), booster.getCartes());
    }

    // Lister tous les boosters
    public List<BoosterDTO> lister() {
        return boosterRepo.findAll().stream()
                .map(b -> new BoosterDTO(b.getId(), b.getDateOuverture(), b.getCartes()))
                .toList();
    }
}
