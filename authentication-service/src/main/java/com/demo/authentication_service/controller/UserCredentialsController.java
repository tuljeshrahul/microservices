package com.demo.authentication_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.authentication_service.entity.UserCredentialsEntity;
import com.demo.authentication_service.service.UserCredentialsService;

@RestController
@RequestMapping("/api/auth")
public class UserCredentialsController {
	@Autowired
	private UserCredentialsService userCredService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping("/register")
	public UserCredentialsEntity register(@RequestBody UserCredentialsEntity user) {
		return userCredService.register(user);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/validate/token")
	public boolean validateToken(@RequestParam String token) {
		return userCredService.verifyToken(token);
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@PostMapping("/validate/user")
	public String getToken(@RequestBody UserCredentialsEntity user) {
		System.out.println("user : " + user);
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
		System.out.println("authenticated?? : " + authenticate.isAuthenticated());
		if (authenticate.isAuthenticated()) {
			return userCredService.generateToken(user.getName());
		}
		return null;
	}
}
