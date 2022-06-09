package com.example.springfinalproject.controoler;

import com.example.springfinalproject.DTO.API;
import com.example.springfinalproject.DTO.ServiceShopDTO;
import com.example.springfinalproject.DTO.UserDTO;
import com.example.springfinalproject.model.Customer;
import com.example.springfinalproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(){
        logger.info("getCustomer it's used");
        return ResponseEntity.status(201).body(customerService.getCustomer());
    }

    @PostMapping
    public ResponseEntity<API> addCustomer(@RequestBody @Valid UserDTO userDTO){
        String message = customerService.addCustomer(userDTO);
        logger.info("addCustomer it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }
    @PostMapping("/add")
    public ResponseEntity<API> addCustomer1(@RequestBody @Valid UserDTO userDTO){
        String message = customerService.addCustomer(userDTO);
        logger.info("addCustomer it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }

    @PutMapping("/service")
    public ResponseEntity<API> addServiceToCustomer(@RequestBody ServiceShopDTO serviceShopDTO){
        String message = customerService.addServiceToCustomer(serviceShopDTO);
        logger.info("addServiceToCustomer it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }
}
