package com.example.springfinalproject.controoler;

import com.example.springfinalproject.DTO.API;
import com.example.springfinalproject.DTO.CustomerDTO;
import com.example.springfinalproject.DTO.ServiceShopDTO;
import com.example.springfinalproject.model.Customer;
import com.example.springfinalproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(){
        return ResponseEntity.status(201).body(customerService.getCustomer());
    }

    @PostMapping
    public ResponseEntity<API> addCustomer(@RequestBody @Valid Customer customer){
        String message = customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(new API(message,200));
    }

    @PostMapping("/service")
    public ResponseEntity<API> addServiceToCustomer(@RequestBody ServiceShopDTO serviceShopDTO){
        String message = customerService.addServiceToCustomer(serviceShopDTO);
        return ResponseEntity.status(200).body(new API(message,200));
    }
}
