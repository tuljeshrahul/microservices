package com.demo.student_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.student_service.entity.StudentEntity;

public interface StudentDao extends JpaRepository<StudentEntity, Long>{
	List<StudentEntity> findByStuSchoolCode(String sCode);
}
