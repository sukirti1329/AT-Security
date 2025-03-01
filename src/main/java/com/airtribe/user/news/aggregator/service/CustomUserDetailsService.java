package com.airtribe.user.news.aggregator.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    //TODO: HAVE TO CHANGE THIS WITH DB VALIDATION
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!"user".equals(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.withUsername("user")
                .password("{noop}password") // No encoding for demo purposes
                .roles("USER")
                .build();
    }
}

