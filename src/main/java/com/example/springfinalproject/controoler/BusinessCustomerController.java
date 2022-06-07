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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/business")
@RequiredArgsConstructor
public class BusinessCustomerController {

    private final BusinessCustomerService businessCustomerService;

    Logger logger = LoggerFactory.getLogger(BusinessCustomerController.class);

    @GetMapping
    public ResponseEntity<List<BusinessCustomer>> getBusiness(){
        logger.info("getBusiness it's used");
        return ResponseEntity.status(201).body(businessCustomerService.getCustomer());
    }

    @PostMapping
    public ResponseEntity<API> addBusiness(@RequestBody @Valid BusinessCustomer businessCustomer){
        String message = businessCustomerService.addCustomer(businessCustomer);
        logger.info("addBusiness it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }
    @PutMapping("/customer")
    public ResponseEntity<API> addCustomerToBusiness(@RequestBody CustomerDTO customerDTO){
        String message = businessCustomerService.addCustomerToBusiness(customerDTO);
        logger.info("addCustomerToBusiness it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }

    @PutMapping("/add/service")
    public ResponseEntity<API> addServiceToBusiness(@RequestBody ServiceBusinessDTO serviceBusinessDTO){
        String message = businessCustomerService.addServiceToBusiness(serviceBusinessDTO);
        logger.info("addServiceToBusiness it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }

    @GetMapping("/service")
    public ResponseEntity<List<ServiceShop>> getServices(){
        logger.info("getServices it's used");
        return ResponseEntity.status(201).body(businessCustomerService.getServices());
    }

    @PostMapping("/service")
    public ResponseEntity<API> addService(@RequestBody @Valid ServiceShop serviceShop){
        String message = businessCustomerService.addService(serviceShop);
        logger.info("addService it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }
    @DeleteMapping("service/{index}")
    public ResponseEntity<API> deleteService(@PathVariable Integer index){
        String message = businessCustomerService.deleteService(index);
        logger.info("deleteService it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }
    @GetMapping("/discount")
    public ResponseEntity<List<DiscountOffer>> getDiscount(){
        logger.info("getDiscount it's used");
        return ResponseEntity.status(201).body(businessCustomerService.getDiscount());
    }

    @PostMapping("/discount")
    public ResponseEntity<API> addDiscount(@RequestBody @Valid DiscountOffer discountOffer){
        String message = businessCustomerService.addDiscount(discountOffer);
        logger.info("addDiscount it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }
    @PutMapping("/service/discount")
    public ResponseEntity<API> addDiscountToService(@RequestBody DiscountShopDTO discountShopDTO){
        String message = businessCustomerService.addDiscountToService(discountShopDTO);
        logger.info("addDiscountToService it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }

    @DeleteMapping("discount/{index}")
    public ResponseEntity<API> deleteDiscount(@PathVariable Integer index){
        String message = businessCustomerService.deleteDiscount(index);
        logger.info("deleteDiscount it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }

}
