package com.example.springfinalproject.service;

import com.example.springfinalproject.DTO.DiscountShopDTO;
import com.example.springfinalproject.exception.InvalidException;
import com.example.springfinalproject.model.DiscountOffer;
import com.example.springfinalproject.model.ServiceShop;
import com.example.springfinalproject.repository.DiscountOfferRepository;
import com.example.springfinalproject.repository.ServiceShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountOfferService {
    private final DiscountOfferRepository discountOfferRepository;


    public List<DiscountOffer> getDiscount() {
        return discountOfferRepository.findAll();
    }

    public String addDiscount(DiscountOffer discountOffer) {
        discountOfferRepository.save(discountOffer);
        return "discount offer add !";
    }


}
