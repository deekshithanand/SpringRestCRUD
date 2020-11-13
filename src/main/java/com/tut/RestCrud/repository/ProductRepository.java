package com.tut.RestCrud.repository;

import com.tut.RestCrud.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>{
    Product findByName(String name);
}
