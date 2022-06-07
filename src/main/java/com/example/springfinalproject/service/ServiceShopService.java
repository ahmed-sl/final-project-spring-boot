package com.example.springfinalproject.service;

import com.example.springfinalproject.DTO.DiscountShopDTO;
import com.example.springfinalproject.exception.InvalidException;
import com.example.springfinalproject.model.BusinessCustomer;
import com.example.springfinalproject.model.DiscountOffer;
import com.example.springfinalproject.model.ServiceShop;
import com.example.springfinalproject.repository.BusinessCustomerRepository;
import com.example.springfinalproject.repository.DiscountOfferRepository;
import com.example.springfinalproject.repository.ServiceShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceShopService {
    private final ServiceShopRepository serviceShopRepository;
    private final DiscountOfferRepository discountOfferRepository;

    public List<ServiceShop> getService() {
        return serviceShopRepository.findAll();
    }

    public String addService(ServiceShop serviceShop) {
        serviceShopRepository.save(serviceShop);
        return "Service shop is add !";
    }

    public String addDiscountToService(DiscountShopDTO discountShopDTO) {
        DiscountOffer discountOffer = discountOfferRepository.findById(discountShopDTO.getDiscountID()).
                orElseThrow(()->new InvalidException("invalid discount id"));
        ServiceShop serviceShop = serviceShopRepository.findById(discountShopDTO.getServiceShopID()).
                orElseThrow(()->new InvalidException("invalid service id"));
        discountOffer.getServiceShops().add(serviceShop);
        discountOfferRepository.save(discountOffer);
        serviceShop.getDiscountOffers().add(discountOffer);
        serviceShopRepository.save(serviceShop);
        return "add discount to service";
    }
}
