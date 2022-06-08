package com.example.springfinalproject.repository;

import com.example.springfinalproject.model.Customer;
import com.example.springfinalproject.model.ServiceShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    Optional<Customer> findCustomerByUser(String username);
    Customer findCustomerByRegisters(ServiceShop serviceShops);
}
