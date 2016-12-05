package com.amir.services;

import com.amir.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private BlogUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repo.findByEmail(email);
    }
}
