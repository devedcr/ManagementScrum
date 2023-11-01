package com.solutioncode.scrum.component.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class CustomUser extends User {

    private Long id;
    private String email;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUser(Long id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
