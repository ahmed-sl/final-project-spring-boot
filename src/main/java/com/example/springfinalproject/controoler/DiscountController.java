package com.example.springfinalproject.controoler;

import com.example.springfinalproject.DTO.API;
import com.example.springfinalproject.DTO.DiscountShopDTO;
import com.example.springfinalproject.model.DiscountOffer;
import com.example.springfinalproject.model.ServiceShop;
import com.example.springfinalproject.service.DiscountOfferService;
import com.example.springfinalproject.service.ServiceShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/discount")
@RequiredArgsConstructor
public class DiscountController {

//    private final DiscountOfferService discountOfferService;

//    @GetMapping
//    public ResponseEntity<List<DiscountOffer>> getDiscount(){
//        return ResponseEntity.status(201).body(discountOfferService.getDiscount());
//    }
//
//    @PostMapping
//    public ResponseEntity<API> addDiscount(@RequestBody @Valid DiscountOffer discountOffer){
//        String message = discountOfferService.addDiscount(discountOffer);
//        return ResponseEntity.status(200).body(new API(message,200));
//    }
}
