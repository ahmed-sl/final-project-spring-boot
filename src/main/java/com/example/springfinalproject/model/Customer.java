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
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "phone number is required")
    @Pattern(regexp = "^(009665|9665|\\+9665|05|5)[013456789][0-9]{7}$",message = "invalid phone Number")
    private String phoneNumber;
    @NotEmpty(message = "email is required")
    @Email(message = "email must be valid")
    private String email;

    // create constructor to add myUser to customer without other relation
    public Customer(Integer id, String phoneNumber, String email, MyUser user) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.user = user;
    }

    @OneToOne(cascade  = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private MyUser user;

    @ManyToOne
    @JsonIgnore
    private BusinessCustomer businessCustomer;

    @OneToMany(mappedBy = "customer")
    private Set<ServiceShop> registers;

}
