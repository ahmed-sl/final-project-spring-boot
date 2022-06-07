package com.example.springfinalproject.repository;

import com.example.springfinalproject.model.Customer;
import com.example.springfinalproject.model.DiscountOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountOfferRepository extends JpaRepository<DiscountOffer,Integer> {
}
