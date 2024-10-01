package com.ust.department_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.ust.department_service.model.DepartmentPojo;
import com.ust.department_service.model.EmployeePojo;
import com.ust.department_service.service.DepartmentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class DepartmentController {
	DepartmentService deptService;
	
	public static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	public DepartmentController(DepartmentService deptService) {		
		this.deptService = deptService;
	}
	
	@GetMapping("/departments")
	public List<DepartmentPojo> getAll(){
		LOG.info("aLL Departments");
		return deptService.getAllDepartments();	
	}
	
	@GetMapping("/departments/{did}")
	@CircuitBreaker(name="ciremp",fallbackMethod="empFallBack")
	public DepartmentPojo getADepartment(@PathVariable("did") long deptId) {
		System.out.println(deptId);
		LOG.info("a Department");
		DepartmentPojo depo=deptService.getADepartment(deptId);
		
		RestClient rest=RestClient.create();
		List<EmployeePojo> allEmps=rest.get().uri("http://localhost:8082/api/employees/departments/"+deptId)
		.retrieve().body(List.class);
		depo.setAllEmp(allEmps);
		return depo;
	}
	
	public DepartmentPojo empFallBack() {
		return new DepartmentPojo(0,"fallback",null);
	}
	
	@PostMapping("/departments")
	public DepartmentPojo addDept(@RequestBody DepartmentPojo newDept) {
		System.out.println(newDept);
		LOG.info("new Department");
		
		return deptService.addADepartment(newDept);
	}
	
	@PutMapping("/departments")
	public DepartmentPojo updateDept(@RequestBody DepartmentPojo editDept) {
		LOG.info("edit Department");
		return deptService.updateDepartment(editDept);
	}
	
	@DeleteMapping("/departments/{did}")
	public void removeDept(@PathVariable("did") long deptId) {
		LOG.info("delete Department");
		deptService.deleteDepartment(deptId);
	}
}
