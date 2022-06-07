package com.example.springfinalproject.controoler;

import com.example.springfinalproject.DTO.API;
import com.example.springfinalproject.DTO.DiscountShopDTO;
import com.example.springfinalproject.model.BusinessCustomer;
import com.example.springfinalproject.model.ServiceShop;
import com.example.springfinalproject.service.BusinessCustomerService;
import com.example.springfinalproject.service.ServiceShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/service")
@RequiredArgsConstructor
public class ServiceShopController {

    private final ServiceShopService serviceShopService;

//    @GetMapping
//    public ResponseEntity<List<ServiceShop>> getService(){
//        return ResponseEntity.status(201).body(serviceShopService.getService());
//    }
//
//    @PostMapping
//    public ResponseEntity<API> addService(@RequestBody @Valid ServiceShop serviceShop){
//        String message = serviceShopService.addService(serviceShop);
//        return ResponseEntity.status(200).body(new API(message,200));
//    }

//    @PostMapping("/discount")
//    public ResponseEntity<API> addDiscountToService(@RequestBody DiscountShopDTO discountShopDTO){
//        String message = serviceShopService.addDiscountToService(discountShopDTO);
//        return ResponseEntity.status(200).body(new API(message,200));
//    }
}
