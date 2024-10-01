package com.demo.monolithic_spring_security_product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.demo.monolithic_spring_security_product.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	@Bean
	public UserDetailsService userDetailsService() {
//		UserDetails customer=User.withUsername("user")
//								.password(passwordEncoder.encode("user"))
//								.roles("USER")
//								.build();
//		UserDetails admin=User.withUsername("admin")
//								.password(passwordEncoder.encode("admin"))
//								.roles("ADMIN")
//								.build();
//		return new InMemoryUserDetailsManager(customer,admin);
		return new CustomUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth ->auth.requestMatchers("/h2-console/**")
		.permitAll()
		.anyRequest()
		.authenticated())
		.formLogin(Customizer.withDefaults())
		.headers((headers)->headers.frameOptions((frame)->frame.sameOrigin()))
		.build();
		
//		http.csrf(csrf->csrf.disable())
//		.authorizeHttpRequests(auth->auth.anyRequest().permitAll())
//		.headers((headers)->headers.frameOptions((frame)->frame.sameOrigin()));
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	authenticationProvider.setUserDetailsService(userDetailsService());
	authenticationProvider.setPasswordEncoder(passwordEncoder());
	return authenticationProvider;
	}

}
