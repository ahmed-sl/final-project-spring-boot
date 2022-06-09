package com.example.springfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ServiceShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "service type is required")
    private String serviceType;
    @NotNull(message = "price is required")
    private Integer price;
    @NotNull(message = "day number is required")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer dayNumber;
    private Calendar calendar = Calendar.getInstance();

    // create constructor to optimize date
    public ServiceShop(Integer id, String serviceType, Integer price, Integer dayNumber) {
        this.id = id;
        this.serviceType = serviceType;
        this.price = price;
        this.dayNumber = dayNumber;
        this.calendar.add(Calendar.DATE,dayNumber);
    }

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JsonIgnore
    private BusinessCustomer businessCustomer;

    @ManyToMany(mappedBy = "serviceShops", cascade = CascadeType.ALL)
    private Set<DiscountOffer> discountOffers;
}
