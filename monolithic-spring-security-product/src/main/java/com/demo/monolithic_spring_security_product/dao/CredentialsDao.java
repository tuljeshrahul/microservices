package com.demo.monolithic_spring_security_product.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.monolithic_spring_security_product.entity.Credentials;

public interface CredentialsDao extends JpaRepository<Credentials, Integer>{
	Optional<Credentials> findByCredUser(String credUser);
}
