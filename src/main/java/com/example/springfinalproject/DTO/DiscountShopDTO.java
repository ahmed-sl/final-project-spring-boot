package com.example.springfinalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
public class DiscountShopDTO {
    @NotNull(message = "discount id is required")
    private Integer discountID;
    @NotNull(message = "service id is required")
    private Integer serviceShopID;
}
