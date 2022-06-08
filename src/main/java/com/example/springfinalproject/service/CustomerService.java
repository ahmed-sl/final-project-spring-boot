package com.example.springfinalproject.service;

import com.example.springfinalproject.DTO.CustomerDTO;
import com.example.springfinalproject.DTO.ServiceShopDTO;
import com.example.springfinalproject.exception.InvalidException;
import com.example.springfinalproject.model.BusinessCustomer;
import com.example.springfinalproject.model.Customer;
import com.example.springfinalproject.model.ServiceShop;
import com.example.springfinalproject.repository.BusinessCustomerRepository;
import com.example.springfinalproject.repository.CustomerRepository;
import com.example.springfinalproject.repository.ServiceShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ServiceShopRepository serviceShopRepository;
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    public String addCustomer(Customer customer) {
        customer.setRole(customer.getRole().toUpperCase());
        customerRepository.save(customer);
        return "customer add !";
    }

    public String addServiceToCustomer(ServiceShopDTO serviceShopDTO) {
        Customer customer = customerRepository.findById(serviceShopDTO.getCustomerID()).
                orElseThrow(()-> new InvalidException("Invalid customer id"));
        ServiceShop serviceShop = serviceShopRepository.findById(serviceShopDTO.getServiceShopID()).
                orElseThrow(()-> new InvalidException("invalid service id"));
        Customer customer1 = customerRepository.findCustomerByRegisters(serviceShop);
        if (customer1 == null){
            customer.getRegisters().add(serviceShop);
            customerRepository.save(customer);
            serviceShop.setCustomer(customer);
            serviceShopRepository.save(serviceShop);
            return "add service to customer !";
        }
        return "other customer take this service";
    }

    public void serachService(){

    }
}
