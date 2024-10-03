package com.demo.authentication_service.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.authentication_service.entity.UserCredentialsEntity;

public class CustomUserDetails implements UserDetails{
	private String name;
	private String password;
	private List<SimpleGrantedAuthority> allRoles;
	
	public CustomUserDetails(UserCredentialsEntity user) {
	this.name = user.getName();
	this.password = user.getPassword();	
	this.allRoles = user.getAllRoles().stream().map((role)-> new SimpleGrantedAuthority(role.getRoleName())).toList();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.allRoles;
	}

	@Override
	public String getPassword() {
	return password;
	}

	@Override
	public String getUsername() {
	return name;
	}

}
