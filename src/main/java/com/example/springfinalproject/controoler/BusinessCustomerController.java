package com.example.springfinalproject.controoler;

import com.example.springfinalproject.DTO.API;
import com.example.springfinalproject.DTO.CustomerDTO;
import com.example.springfinalproject.DTO.DiscountShopDTO;
import com.example.springfinalproject.DTO.ServiceBusinessDTO;
import com.example.springfinalproject.model.BusinessCustomer;
import com.example.springfinalproject.model.Customer;
import com.example.springfinalproject.model.DiscountOffer;
import com.example.springfinalproject.model.ServiceShop;
import com.example.springfinalproject.service.BusinessCustomerService;
import com.example.springfinalproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/business")
@RequiredArgsConstructor
public class BusinessCustomerController {

    private final BusinessCustomerService businessCustomerService;

    @GetMapping
    public ResponseEntity<List<BusinessCustomer>> getBusiness(){
        return ResponseEntity.status(201).body(businessCustomerService.getCustomer());
    }

    @PostMapping
    public ResponseEntity<API> addBusiness(@RequestBody @Valid BusinessCustomer businessCustomer){
        String message = businessCustomerService.addCustomer(businessCustomer);
        return ResponseEntity.status(200).body(new API(message,200));
    }
    @PostMapping("/customer")
    public ResponseEntity<API> addCustomerToBusiness(@RequestBody CustomerDTO customerDTO){
        String message = businessCustomerService.addCustomerToBusiness(customerDTO);
        return ResponseEntity.status(200).body(new API(message,200));
    }

    @PostMapping("/service")
    public ResponseEntity<API> addServiceToBusiness(@RequestBody ServiceBusinessDTO serviceBusinessDTO){
        String message = businessCustomerService.addServiceToBusiness(serviceBusinessDTO);
        return ResponseEntity.status(200).body(new API(message,200));
    }

    @GetMapping("/service")
    public ResponseEntity<List<ServiceShop>> getServices(){
        return ResponseEntity.status(201).body(businessCustomerService.getServices());
    }

    @PostMapping("/service/add")
    public ResponseEntity<API> addService(@RequestBody @Valid ServiceShop serviceShop){
        String message = businessCustomerService.addService(serviceShop);
        return ResponseEntity.status(200).body(new API(message,200));
    }
    @GetMapping("/discount")
    public ResponseEntity<List<DiscountOffer>> getDiscount(){
        return ResponseEntity.status(201).body(businessCustomerService.getDiscount());
    }

    @PostMapping("/discount")
    public ResponseEntity<API> addDiscount(@RequestBody @Valid DiscountOffer discountOffer){
        String message = businessCustomerService.addDiscount(discountOffer);
        return ResponseEntity.status(200).body(new API(message,200));
    }
    @PostMapping("/service/discount")
    public ResponseEntity<API> addDiscountToService(@RequestBody DiscountShopDTO discountShopDTO){
        String message = businessCustomerService.addDiscountToService(discountShopDTO);
        return ResponseEntity.status(200).body(new API(message,200));
    }
}
