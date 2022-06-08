package com.example.springfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

//@AllArgsConstructor
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Customer  { //implements UserDetails
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "phone number is required")
    private String phoneNumber;
    @NotEmpty(message = "email is required")
    @Email(message = "email must be valid")
    private String email;

    public Customer(Integer id, String phoneNumber, String email, MyUser user) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.user = user;
    }

    @OneToOne(cascade  = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "customer_id")
    private MyUser user;

    @ManyToOne
    @JsonIgnore
    private BusinessCustomer businessCustomer;

    @OneToMany(mappedBy = "customer")
    private Set<ServiceShop> registers;


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority(this.role));
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
