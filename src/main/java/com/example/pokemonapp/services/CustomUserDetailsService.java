package com.example.pokemonapp.services;

import com.example.pokemonapp.entities.Dresseur;
import com.example.pokemonapp.repositories.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private DresseurRepository dresseurRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Dresseur d = dresseurRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable"));

        return new User(
                d.getUsername(),
                d.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(d.getRole()))
        );
    }
}
