package com.example.springfinalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
public class ServiceBusinessDTO {
    @NotNull(message = "business id is required")
    private Integer businessID;
    @NotNull(message = "serviceShop id is required")
    private Integer serviceShopID;
}
