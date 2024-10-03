package com.demo.school_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.school_service.dao.SchoolDao;
import com.demo.school_service.entity.SchoolEntity;
import com.demo.school_service.model.SchoolPojo;

@Service
public class SchoolService {
	@Autowired
	SchoolDao dao;
	
	public List<SchoolPojo> getAll(){
		List<SchoolEntity> schools=dao.findAll();
		List<SchoolPojo> pojo=new ArrayList<SchoolPojo>();
		schools.stream().forEach((school)->{
			SchoolPojo sch=new SchoolPojo();
			BeanUtils.copyProperties(school, sch);
			pojo.add(sch);
		});
		return pojo;
	}
	
	public SchoolPojo getASchool(String schoolCode) {
		Optional<SchoolEntity> school=dao.findById(schoolCode);
		if(school.isPresent()) {
			SchoolPojo pojo=new SchoolPojo();
			BeanUtils.copyProperties(school.get(), pojo);
			return pojo;
		}
		return null;
	}
	
	public SchoolPojo addASchool(SchoolPojo pojo) {
		SchoolEntity school=new SchoolEntity();
		BeanUtils.copyProperties(pojo, school);
		dao.saveAndFlush(school);
		return pojo;
	}
	
	public SchoolPojo updateASchool(SchoolPojo pojo) {
		SchoolEntity school=new SchoolEntity();
		BeanUtils.copyProperties(pojo, school);
		dao.saveAndFlush(school);
		return pojo;
	} 
	
	public void deleteASchool(String schoolCode) {
		dao.deleteById(schoolCode);
	}
}
