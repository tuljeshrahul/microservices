package com.demo.monolithic_spring_security_product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.monolithic_spring_security_product.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

}
