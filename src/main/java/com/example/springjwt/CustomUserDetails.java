package com.example.springjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {
    private final UserRepo userRepo;

    @Autowired
    public CustomUserDetails (UserRepo userRepo){

        this.userRepo=userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userDetails = userRepo.findUserEntityByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username not found"));
        return new User(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
    }
}
