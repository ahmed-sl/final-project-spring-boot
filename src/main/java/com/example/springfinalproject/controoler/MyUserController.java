package com.example.springfinalproject.controoler;

import com.example.springfinalproject.model.MyUser;
import com.example.springfinalproject.service.MyUserSercive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class MyUserController {
    private final MyUserSercive myUserSercive;

    @GetMapping
    public ResponseEntity getUsers(){
        return ResponseEntity.status(201).body(myUserSercive.getUsers());
    }

    @PostMapping("/register")
    public ResponseEntity addUser(@RequestBody @Valid MyUser myUser){
        return ResponseEntity.status(200).body(myUserSercive.addUser(myUser));
    }
}
