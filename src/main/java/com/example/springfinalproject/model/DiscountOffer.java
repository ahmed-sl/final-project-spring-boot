package com.example.springfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class DiscountOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "discount type is required")
    private String discountType;
    @NotNull(message = "day number is required")
    private Integer dayNumber;
    private Calendar expiryDateDiscount = Calendar.getInstance();

    // create constructor to optimize date
    public DiscountOffer(Integer id, String discountType, Integer dayNumber) {
        this.id = id;
        this.discountType = discountType;
        this.dayNumber = dayNumber;
        this.expiryDateDiscount.add(Calendar.DATE,dayNumber);
    }

    @ManyToMany
    @JsonIgnore
    private Set<ServiceShop> serviceShops;
}
