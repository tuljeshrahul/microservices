package com.demo.school_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.school_service.model.SchoolPojo;
import com.demo.school_service.service.SchoolService;

@RestController
@RequestMapping("/schools")
public class SchoolController {
	@Autowired
	SchoolService service;
	
	@GetMapping
	public List<SchoolPojo> getAll(){
		return service.getAll();
	}
	
	@PostMapping
	public SchoolPojo addASchool(@RequestBody SchoolPojo pojo)
	{
		return service.addASchool(pojo);
	}
	
	@GetMapping("/{sCode}")
	public SchoolPojo getASchool(@PathVariable("sCode") String schoolCode)
	{
		return service.getASchool(schoolCode);
	}
	
	@PutMapping
	public SchoolPojo updateASchool(@RequestBody SchoolPojo pojo)
	{
		return service.updateASchool(pojo);
	}
	
	@DeleteMapping("/{sCode}")
	public void deleteASchool(@PathVariable("sCode") String schoolCode) {
		service.deleteASchool(schoolCode);
	}
}
