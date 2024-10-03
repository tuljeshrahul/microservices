package com.demo.school_service.entity;

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
public class SchoolEntity {
	@Id
	@Column(name="school_code")
	private String schoolCode;
	@Column(name="school_name")
	private String schoolName;
}
