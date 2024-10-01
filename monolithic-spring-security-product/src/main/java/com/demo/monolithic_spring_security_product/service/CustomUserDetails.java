package com.demo.monolithic_spring_security_product.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.demo.monolithic_spring_security_product.entity.Roles;

public class CustomUserDetails implements UserDetails{

	private String name;
	private String password;
	private List<SimpleGrantedAuthority> allRoles;
	
	public CustomUserDetails(String name, String password, List<Roles> allRoles) {
	super();
	this.name = name;
	this.password = password;
	this.allRoles = allRoles.stream().map((role)-> new SimpleGrantedAuthority(role.getRoleName())).toList();
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.allRoles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
