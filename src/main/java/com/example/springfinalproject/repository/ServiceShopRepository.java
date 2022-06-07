package com.example.springfinalproject.repository;

import com.example.springfinalproject.model.ServiceShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceShopRepository extends JpaRepository<ServiceShop,Integer> {
}
