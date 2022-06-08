package com.example.springfinalproject.service;

import com.example.springfinalproject.model.Customer;
import com.example.springfinalproject.model.MyUser;
import com.example.springfinalproject.repository.CustomerRepository;
import com.example.springfinalproject.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserRepository.findMyUserByUsername(username).
                orElseThrow(()->new UsernameNotFoundException("username not found"));

        return myUser;
    }
}
