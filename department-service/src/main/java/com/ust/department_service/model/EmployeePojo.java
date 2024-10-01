package com.ust.department_service.model;

import jakarta.persistence.Id;

public class EmployeePojo {
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
