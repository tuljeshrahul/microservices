package com.demo.monolithic_spring_security_product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.monolithic_spring_security_product.dao.CredentialsDao;
import com.demo.monolithic_spring_security_product.entity.Credentials;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired 
	CredentialsDao credDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	Optional<Credentials> cred = credDao.findByCredUser(username);
	// but we have return UserDetails and not UserInfoEntity
	return cred
	.map((userInfo)->new CustomUserDetails(userInfo.getCredUser(), userInfo.getCredPassword(), userInfo.getAllRoles()))
	.orElseThrow(()-> new UsernameNotFoundException(username + " not found"));
	}

}
