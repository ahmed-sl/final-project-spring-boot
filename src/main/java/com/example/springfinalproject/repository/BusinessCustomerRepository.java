package com.example.springfinalproject.repository;

import com.example.springfinalproject.model.BusinessCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessCustomerRepository extends JpaRepository<BusinessCustomer,Integer> {
}
