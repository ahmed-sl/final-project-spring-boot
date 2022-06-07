package com.example.springfinalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
public class CustomerDTO {
    @NotNull(message = "customer id is required")
    private Integer customerID;
    @NotNull(message = "businessCustomer id is required")
    private Integer businessCustomerID;
}
