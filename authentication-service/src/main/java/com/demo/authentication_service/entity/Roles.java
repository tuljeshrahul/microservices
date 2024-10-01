package com.demo.authentication_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Roles {
	@Id
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;
}
