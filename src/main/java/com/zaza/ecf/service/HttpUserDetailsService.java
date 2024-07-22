package com.zaza.ecf.service;

import com.zaza.ecf.model.Utilisateur;
import com.zaza.ecf.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HttpUserDetailsService implements UserDetailsService {

    @Autowired
    private  UtilisateurRepository utilisateurRepository;



    @Override
    public UserDetails loadUserByUsername(final String username) {
        final Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByUsername(username);
        if (utilisateurOptional.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        final Utilisateur utilisateur = utilisateurOptional.get();
        System.out.print(utilisateur.getRole().getLabel().toUpperCase());
        final List<SimpleGrantedAuthority> roles = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + utilisateur.getRole().getLabel().toUpperCase()));
        return new User(utilisateur.getUsername(),
                utilisateur.getPassword(),
                true,
                true,
                true,
                true,
                roles);
    }

}