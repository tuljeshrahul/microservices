package com.demo.monolithic_spring_security_product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.monolithic_spring_security_product.dao.ProductDao;
import com.demo.monolithic_spring_security_product.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao dao;
	
	public List<Product> getAllProducts(){
		return dao.findAll();
	}
	
	public Product getAProduct(int prodId) {
		return dao.findById(prodId).get();
	}
	
	public Product addProduct(Product newProd) {
		return dao.saveAndFlush(newProd);
	}
}
