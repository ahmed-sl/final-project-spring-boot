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
    @NotEmpty(message = "address is required")
    private String address;
    @NotEmpty(message = "phone number is required")
    private String phoneNumber;
    @NotEmpty(message = "email is required")
    @Email(message = "email must be valid")
    private String email;
    @NotEmpty(message = "location is required")
    private String location;

    public BusinessCustomer(Integer id, String address, String phoneNumber, String email, String location, MyUser myUser) {
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.location = location;
        this.myUser = myUser;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @Column(name = "business_id")
    @JsonIgnore
    private MyUser myUser;

    @OneToMany(mappedBy = "businessCustomer", cascade = CascadeType.ALL)
    private Set<Customer> customers;
    @OneToMany(mappedBy = "businessCustomer", cascade = CascadeType.ALL)
    private Set<ServiceShop> serviceShops;
}
