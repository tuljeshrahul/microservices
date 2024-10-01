package com.ust.department_service.service;

import java.util.List;

import com.ust.department_service.model.DepartmentPojo;

public interface DepartmentService {
	List<DepartmentPojo> getAllDepartments();
	DepartmentPojo getADepartment(long deptId);
	DepartmentPojo addADepartment(DepartmentPojo newDeptPojo);
	DepartmentPojo updateDepartment(DepartmentPojo editDeptPojo);
	void deleteDepartment(long deptId);
}
