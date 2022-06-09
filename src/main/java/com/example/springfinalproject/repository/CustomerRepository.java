package com.example.springfinalproject.repository;

import com.example.springfinalproject.model.Customer;
import com.example.springfinalproject.model.ServiceShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    // quire to find register
    Customer findCustomerByRegisters(ServiceShop serviceShops);
}
