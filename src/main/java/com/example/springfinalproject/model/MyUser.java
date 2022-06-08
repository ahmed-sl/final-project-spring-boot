package com.example.springfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "username is required")
    @Column(unique = true)
    private String username;
    @NotEmpty(message = "password is required")
    private String password;
    @NotEmpty(message = "role is required")
    @Pattern(regexp = "(?i)(user|admin)",message = "role must be user or admin")
    private String role;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Customer customer;



}
