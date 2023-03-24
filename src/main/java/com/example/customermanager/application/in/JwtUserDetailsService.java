package com.example.customermanager.application.in;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Value("${spring.security.credentials.user}")
    private String userApp;

    @Value("${spring.security.credentials.pass}")
    private String passApp;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userApp.equals(username)) {
            return new User(userApp, passApp, new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
