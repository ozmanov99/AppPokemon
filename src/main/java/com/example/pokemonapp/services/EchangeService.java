package com.example.pokemonapp.services;

import com.example.pokemonapp.entities.Echange;
import com.example.pokemonapp.entities.Pokemon;
import com.example.pokemonapp.repositories.EchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EchangeService {

    @Autowired private EchangeRepository repo;

    // Proposer un échange
    public Echange proposer(Echange e) {
        e.setStatut("EN_ATTENTE");
        return repo.save(e);
    }

    public List<Echange> lister() {

        return repo.findAll();
    }

    public Optional<Echange> rechercher(Long id) {

        return repo.findById(id);
    }

    // Acceptation par un des dresseurs
    public Echange accepter(Long id, Long dresseurId) {
        Optional<Echange> opt = repo.findById(id);
        if (opt.isPresent()) {
            Echange e = opt.get();

            // Vérifier niveau et rareté
            for (Pokemon p1 : e.getCartesDresseur1()) {
                for (Pokemon p2 : e.getCartesDresseur2()) {
                    if (p1.getNiveau() != p2.getNiveau() || !p1.getRarete().equals(p2.getRarete())) {
                        throw new RuntimeException("Les cartes doivent être de même niveau et rareté");
                    }
                }
            }

            // Mise à jour double validation
            if (dresseurId.equals(e.getDresseur1().getId())) {
                e.setStatut(e.getStatut().equals("DRESSEUR2_ACCEPTE") ? "ACCEPTE" : "DRESSEUR1_ACCEPTE");
            } else if (dresseurId.equals(e.getDresseur2().getId())) {
                e.setStatut(e.getStatut().equals("DRESSEUR1_ACCEPTE") ? "ACCEPTE" : "DRESSEUR2_ACCEPTE");
            }

            return repo.save(e);
        }
        return null;
    }

    public Echange refuser(Long id) {
        Optional<Echange> opt = repo.findById(id);
        if (opt.isPresent()) {
            Echange e = opt.get();
            e.setStatut("REFUSE");
            return repo.save(e);
        }
        return null;
    }
}
