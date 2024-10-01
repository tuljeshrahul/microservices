package com.ust.department_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.department_service.dao.DepartmentRepository;
import com.ust.department_service.entity.DepartmentEntity;
import com.ust.department_service.model.DepartmentPojo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	DepartmentRepository deptRepo;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository deptRepo) {
		this.deptRepo = deptRepo;
	}

	@Override
	public List<DepartmentPojo> getAllDepartments() {
		List<DepartmentEntity> allDept=deptRepo.findAll();
		List<DepartmentPojo> allDeptPojo=new ArrayList<>();
		
		allDept.stream().forEach((dept)->{
				DepartmentPojo pojo=new DepartmentPojo();
				BeanUtils.copyProperties(dept, pojo);
				allDeptPojo.add(pojo);});
		return allDeptPojo;
	}

	@Override
	public DepartmentPojo getADepartment(long deptId) {
		Optional<DepartmentEntity> dept=deptRepo.findById(deptId);
		DepartmentPojo pojo=null;
		if(dept.isPresent()) {
			pojo=new DepartmentPojo();
			BeanUtils.copyProperties(dept.get(), pojo);
		}
		return pojo;
	}

	@Override
	public DepartmentPojo addADepartment(DepartmentPojo newDeptPojo) {
		DepartmentEntity dept=new DepartmentEntity();
		BeanUtils.copyProperties(newDeptPojo, dept);
		System.out.println(dept);
		deptRepo.saveAndFlush(dept);
		return newDeptPojo;
	}

	@Override
	public DepartmentPojo updateDepartment(DepartmentPojo editDeptPojo) {
		DepartmentEntity dept=new DepartmentEntity();
		BeanUtils.copyProperties(editDeptPojo, dept);
		deptRepo.saveAndFlush(dept);
		return editDeptPojo;
	}

	@Override
	public void deleteDepartment(long deptId) {
		deptRepo.deleteById(deptId);

	}

}
