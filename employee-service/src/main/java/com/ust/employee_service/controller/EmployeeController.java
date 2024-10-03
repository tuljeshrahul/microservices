package com.ust.employee_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ust.employee_service.dao.EmployeeRepository;
import com.ust.employee_service.entity.EmployeeEntity;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	EmployeeRepository empRepo;
	
	public static final Logger LOG=LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	public EmployeeController(EmployeeRepository empRepo) {		
		this.empRepo = empRepo;
	}
	
	@GetMapping("/employees")
	public List<EmployeeEntity> getAll(){
		LOG.info("All Employees");
		return empRepo.findAll();	
	}
	
	@GetMapping("/employees/departments/{did}")
	public List<EmployeeEntity> getAllEmpByDepartment(@PathVariable("did") long deptId) {
		System.out.println(deptId);
		LOG.info("Employees by deptId");
		return empRepo.findByEmpDeptId(deptId);
	}
	
	@PostMapping("/employees")
	public EmployeeEntity addEmp(@RequestBody EmployeeEntity newEmp) {
		System.out.println(newEmp);
		LOG.info("Add Employees");
		return empRepo.save(newEmp);
	}
	
	@PutMapping("/employees")
	public EmployeeEntity updateEmp(@RequestBody EmployeeEntity editEmp) {
		LOG.info("Update Employees");
		return empRepo.save(editEmp);
	}
	
	@DeleteMapping("/employees/{did}")
	public void removeDept(@PathVariable("did") long empId) {
		LOG.info("Delete Employees");
		empRepo.deleteById(empId);
	}
}
