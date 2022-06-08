package com.example.springfinalproject.service;

import com.example.springfinalproject.model.MyUser;
import com.example.springfinalproject.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserSercive {
    private final MyUserRepository myUserRepository;


    public List<MyUser> getUsers() {
        return myUserRepository.findAll();
    }

    public Object addUser(MyUser myUser) {
        myUser.setRole(myUser.getRole().toUpperCase());
        myUserRepository.save(myUser);
        return myUserRepository.findAll();
    }
}
