package com.demo.student_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="student_details")
public class StudentEntity {
	@Id
	@Column(name="student_id")
	private long studentId;
	
	@Column(name="student_name")
	private String studentName;
	private String stuSchoolCode;
}
