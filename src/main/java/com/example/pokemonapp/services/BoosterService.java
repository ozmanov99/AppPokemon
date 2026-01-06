package com.example.pokemonapp.services;

import com.example.pokemonapp.dto.BoosterDTO;
import com.example.pokemonapp.entities.Booster;
import com.example.pokemonapp.entities.Collection;
import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.entities.Pokemon;
import com.example.pokemonapp.repositories.BoosterRepository;
import com.example.pokemonapp.repositories.CollectionRepository;
import com.example.pokemonapp.repositories.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoosterService {

    @Autowired
    private BoosterRepository boosterRepo;

    @Autowired
    private DresseurRepository dresseurRepo;

    @Autowired
    private CollectionRepository collectionRepo;

    public BoosterDTO ouvrirBoosterParTypePourUsername(String type, String username) {
        // Récupère le dresseur
        Dresseur dresseur = dresseurRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Dresseur introuvable"));

        // Cherche un booster correspondant au type
        Booster booster = boosterRepo.findAll().stream()
                .filter(b -> b.getCartes() != null
                        && !b.getCartes().isEmpty()
                        && b.getCartes().get(0).getType().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun booster de type " + type + " trouvé"));

        List<Pokemon> cartes = booster.getCartes();

        // Tirer une seule carte aléatoire
        Pokemon carteAleatoire = cartes.get((int) (Math.random() * cartes.size()));

        // Ajouter la carte dans la collection du dresseur
        Collection c = new Collection();
        c.setDresseur(dresseur);
        c.setCarte(carteAleatoire);
        collectionRepo.save(c);

        // Retourner le DTO avec une seule carte
        return new BoosterDTO(booster.getId(), LocalDate.now(), List.of(carteAleatoire));
    }

    public List<BoosterDTO> lister() {
        return boosterRepo.findAll().stream()
                .map(b -> new BoosterDTO(b.getId(), b.getDateOuverture(), b.getCartes()))
                .collect(Collectors.toList());
    }
}
