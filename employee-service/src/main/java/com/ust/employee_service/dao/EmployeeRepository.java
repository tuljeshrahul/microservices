package com.ust.employee_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.employee_service.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
	List<EmployeeEntity> findByEmpDeptId(long deptId);
}
