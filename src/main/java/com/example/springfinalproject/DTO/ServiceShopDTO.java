package com.example.springfinalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
public class ServiceShopDTO {
    @NotNull(message = "customer id is required")
    private Integer customerID;
    @NotNull(message = "serviceShop id is required")
    private Integer serviceShopID;
}
