package com.example.springfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class BusinessCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "username is required")
    @Column(unique = true)
    private String username;
    @NotEmpty(message = "password is required")
    private String password;
    @NotEmpty(message = "address is required")
    private String address;
    @NotEmpty(message = "phone number is required")
    private String phoneNumber;
    @NotEmpty(message = "email is required")
    @Email(message = "email must be valid")
    private String email;
    @NotEmpty(message = "location is required")
    private String location;
    @NotEmpty(message = "role is required")
    @Pattern(regexp = "(?i)(user|admin)",message = "role must be user or admin")
    private String role;

    @OneToMany(mappedBy = "businessCustomer", cascade = CascadeType.ALL)
    private Set<Customer> customers;

    @OneToMany(mappedBy = "businessCustomer", cascade = CascadeType.ALL)
    private Set<ServiceShop> serviceShops;




}
