//package com.example.pokemonapp;
//
//import com.example.pokemonapp.entities.Booster;
//import com.example.pokemonapp.entities.Dresseur;
//import com.example.pokemonapp.repositories.BoosterRepository;
//import com.example.pokemonapp.repositories.DresseurRepository;
//import com.example.pokemonapp.services.BoosterService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class BoosterServiceTest {
//
//    @Autowired
//    private BoosterService boosterService;
//
//    @Autowired
//    private DresseurRepository dresseurRepo;
//
//    @Autowired
//    private BoosterRepository boosterRepo;
//
//    @Test
//    public void testOuvrirBooster() {
//        // Création d'un dresseur de test avec le rôle autorisé
//        Dresseur dresseur = new Dresseur();
//        dresseur.setNom("TestNom");
//        dresseur.setPseudo("TestPseudo");
//        dresseur.setNiveau(1);
//        dresseur.setRole("DRESSEUR"); // rôle obligatoire pour ouvrir un booster
//        dresseur = dresseurRepo.save(dresseur);
//
//        // Appel du service pour ouvrir un booster
//        Booster booster = boosterService.ouvrirBooster(dresseur.getId());
//
//        // Vérifications
//        assertNotNull(booster, "Le booster ne doit pas être null");
//        assertEquals(10, booster.getCartes().size(), "Le booster doit contenir 10 cartes");
//        assertEquals(dresseur.getId(), booster.getDresseur().getId(), "Le dresseur doit correspondre");
//    }
//
//    @Test
//    public void testListerBoosters() {
//        // Création d'un dresseur de test
//        Dresseur dresseur = new Dresseur();
//        dresseur.setNom("ListeTest");
//        dresseur.setPseudo("ListePseudo");
//        dresseur.setNiveau(1);
//        dresseur.setRole("DRESSEUR");
//        dresseur = dresseurRepo.save(dresseur);
//
//        // Création de quelques boosters
//        boosterService.ouvrirBooster(dresseur.getId());
//        boosterService.ouvrirBooster(dresseur.getId());
//
//        // Vérification que la liste contient au moins ces deux boosters
//        assertTrue(boosterService.lister().size() >= 2, "Il doit y avoir au moins 2 boosters listés");
//    }
//}
