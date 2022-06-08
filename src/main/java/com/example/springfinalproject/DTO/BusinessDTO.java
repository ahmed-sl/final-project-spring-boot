package com.example.springfinalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
public class BusinessDTO {
    @NotNull(message = "user id is required")
    private Integer myUserID;
    @NotEmpty(message = "address is required")
    private String address;
    @NotEmpty(message = "phone number is required")
    private String phoneNumber;
    @NotEmpty(message = "email is required")
    @Email(message = "email must be valid")
    private String email;
    @NotEmpty(message = "location is required")
    private String location;
}
