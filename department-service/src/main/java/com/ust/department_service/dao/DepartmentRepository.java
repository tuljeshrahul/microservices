package com.ust.department_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.department_service.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>{

}
