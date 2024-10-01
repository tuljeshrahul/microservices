package com.demo.monolithic_spring_security_product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.monolithic_spring_security_product.entity.Credentials;

@RestController
@RequestMapping("/api")
public class CredentialsController {
	@PostMapping("/credentials/validate")
	public Credentials validate(@RequestBody Credentials cred)
	{
		return null;
	}
}
