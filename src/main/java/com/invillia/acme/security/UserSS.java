package com.invillia.acme.security;


import com.invillia.acme.model.enums.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSS implements UserDetails {

    private Long id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> autorities;

    public UserSS() {
        }

    public UserSS(Long id, String email, String password, Set<Profile> perfis) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.autorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescription())).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    public boolean hasRole(Profile profile) {
        return getAuthorities().contains(new SimpleGrantedAuthority(profile.getDescription()));
    }
}
