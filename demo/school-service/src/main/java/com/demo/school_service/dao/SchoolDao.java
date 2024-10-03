package com.demo.school_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.school_service.entity.SchoolEntity;

public interface SchoolDao extends JpaRepository<SchoolEntity, String>{

}
