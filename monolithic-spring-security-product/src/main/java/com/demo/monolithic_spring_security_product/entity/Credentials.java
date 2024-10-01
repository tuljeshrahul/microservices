package com.demo.monolithic_spring_security_product.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Credentials {
	@Id
	@Column(name="cred_id")
	private int credId;
	
	@Column(name="cred_username")
	private String credUser;
	
	@Column(name="cred_password")
	private String credPassword;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="credential_role",
		joinColumns=@JoinColumn(name="cred_id"),
		inverseJoinColumns=@JoinColumn(name="role_id"))
	List<Roles> allRoles;
}
