package com.example.demo.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {//user want to try to login

    private final static String USER_NOT_FOUND_MESSAGE = "user with email %s does not exist!";
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepo.findByEmail ( email )
                .orElseThrow (() -> new UsernameNotFoundException ( String.format ( USER_NOT_FOUND_MESSAGE, email ) ));
    }
}
