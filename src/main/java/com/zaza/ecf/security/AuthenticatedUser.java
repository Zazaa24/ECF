package com.zaza.ecf.security;


import com.zaza.ecf.model.Role;
import com.zaza.ecf.model.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class AuthenticatedUser implements UserDetails {
    private  Utilisateur utilisateur;
    @Override
    public String getUsername() {
        return utilisateur.getUsername();
    }
    @Override
    public String getPassword() {
        return utilisateur.getPassword();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        Role role = utilisateur.getRole();
        System.out.println(role.getLabel().toUpperCase());
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getLabel().toUpperCase());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getLabel().toUpperCase()));
        return authorities;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}