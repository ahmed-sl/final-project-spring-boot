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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BusinessCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "address is required")
    private String address;
    @NotEmpty(message = "phone number is required")
    @Pattern(regexp = "^(009665|9665|\\+9665|05|5)[013456789][0-9]{7}$",message = "invalid phone Number")
    private String phoneNumber;
    @NotEmpty(message = "email is required")
    @Email(message = "email must be valid")
    private String email;
    @NotEmpty(message = "location is required")
    private String location;

    // create constructors to add myUser to business customer without  other relation
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
    @JoinColumn(name = "business_id")
    @JsonIgnore
    private MyUser myUser;

    @OneToMany(mappedBy = "businessCustomer", cascade = CascadeType.ALL)
    private Set<Customer> customers;

    @OneToMany(mappedBy = "businessCustomer", cascade = CascadeType.ALL)
    private Set<ServiceShop> serviceShops;
}
