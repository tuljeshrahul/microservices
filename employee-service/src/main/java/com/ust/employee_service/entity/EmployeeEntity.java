package com.ust.employee_service.entity;

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
//@Table(name="department_details")
public class EmployeeEntity {
	@Id
//	@Column(name="dept_id")
	private long empId;
	
//	@Column(name="dept_name")
	private String empName;
	private String empDesignation;
	private long empDeptId;
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public long getEmpDeptId() {
		return empDeptId;
	}
	public void setEmpDeptId(long empDeptId) {
		this.empDeptId = empDeptId;
	}
}
