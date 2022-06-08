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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class MyUser implements UserDetails {
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
    private Customer customer;

    @OneToOne(mappedBy = "myUser",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BusinessCustomer businessCustomer;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
