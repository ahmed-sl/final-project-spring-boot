package com.example.springfinalproject.service;

import com.example.springfinalproject.DTO.*;
import com.example.springfinalproject.exception.InvalidException;
import com.example.springfinalproject.model.*;
import com.example.springfinalproject.repository.BusinessCustomerRepository;
import com.example.springfinalproject.repository.CustomerRepository;
import com.example.springfinalproject.repository.MyUserRepository;
import com.example.springfinalproject.repository.ServiceShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessCustomerService {
    private final BusinessCustomerRepository businessCustomerRepository;
    private final CustomerRepository customerRepository;
    private final ServiceShopRepository serviceShopRepository;
    private final ServiceShopService serviceShopService;
    private final DiscountOfferService discountOfferService;
    private final MyUserRepository myUserRepository;

    public List<BusinessCustomer> getCustomer() {
        return businessCustomerRepository.findAll();
    }

    public String addBusiness(BusinessDTO businessDTO) {
        MyUser myUser = myUserRepository.findById(businessDTO.getMyUserID()).
                orElseThrow(()->new InvalidException("Invalid user id"));
        BusinessCustomer businessCustomer = new BusinessCustomer(
                null,businessDTO.getAddress(),businessDTO.getPhoneNumber(),
                businessDTO.getEmail(),businessDTO.getLocation(),myUser);
        businessCustomerRepository.save(businessCustomer);
        return "add business customer !";
    }

    public String addCustomerToBusiness(CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerDTO.getCustomerID()).
                orElseThrow(()-> new InvalidException("Invalid customerID"));
        BusinessCustomer businessCustomer = businessCustomerRepository.findById(customerDTO.getBusinessCustomerID()).
                orElseThrow(()-> new InvalidException("Invalid customerID"));
        customer.setBusinessCustomer(businessCustomer);
        customerRepository.save(customer);
        businessCustomer.getCustomers().add(customer);
        businessCustomerRepository.save(businessCustomer);
        return "Customer add to business !";
    }

    public String addServiceToBusiness(ServiceBusinessDTO serviceBusinessDTO) {
        BusinessCustomer businessCustomer = businessCustomerRepository.findById(serviceBusinessDTO.getBusinessID()).
                orElseThrow(()->new InvalidException("invalid business id"));
        ServiceShop serviceShop = serviceShopRepository.findById(serviceBusinessDTO.getServiceShopID()).
                orElseThrow(()->new InvalidException("invalid service id"));
        businessCustomer.getServiceShops().add(serviceShop);
        businessCustomerRepository.save(businessCustomer);
        serviceShop.setBusinessCustomer(businessCustomer);
        serviceShopRepository.save(serviceShop);
        return "add service to business !";
    }


    public List<ServiceShop> getServices() {
        return serviceShopService.getService();
    }

    public String addService(ServiceShop serviceShop) {
        return serviceShopService.addService(serviceShop);
    }

    public String addDiscount(DiscountOffer discountOffer) {

        return discountOfferService.addDiscount(discountOffer);
    }

    public List<DiscountOffer> getDiscount() {
        return discountOfferService.getDiscount();

    }


    public String addDiscountToService(DiscountShopDTO discountShopDTO) {
        return serviceShopService.addDiscountToService(discountShopDTO);
    }

    public String deleteService(Integer index) {
        return serviceShopService.deleteService(index);
    }

    public String deleteDiscount(Integer index) {
        return discountOfferService.deleteDiscount(index);
    }
}
