//package com.example.springfinalproject.service;
//
//import com.example.springfinalproject.model.Customer;
//import com.example.springfinalproject.repository.CustomerRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class MyUserDetailsService implements UserDetailsService {
//    private final CustomerRepository customerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer customer = customerRepository.findByUsername(username).orElseThrow(
//                ()->new UsernameNotFoundException("username or password is wrong"));
//
//        return customer;
//    }
//}
