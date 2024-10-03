package com.demo.student_service.controller;

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

import com.demo.student_service.dao.StudentDao;
import com.demo.student_service.entity.StudentEntity;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentDao dao;
	public static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

	@GetMapping
	public List<StudentEntity> getAll() {
		LOG.info("All Students");
		return dao.findAll();
	}

	@GetMapping("/schools/{sid}")
	public List<StudentEntity> getAllStudentsBySchoolCode(@PathVariable("sid") String sCode) {
//		System.out.println(deptId);
		LOG.info("Students by school");
		return dao.findByStuSchoolCode(sCode);
	}

	@PostMapping
	public StudentEntity add(@RequestBody StudentEntity newStu) {
		System.out.println(newStu);
		LOG.info("Add Student");
		return dao.save(newStu);
	}

	@PutMapping
	public StudentEntity update(@RequestBody StudentEntity editStu) {
		LOG.info("Update Student");
		return dao.save(editStu);
	}

	@DeleteMapping("/{sid}")
	public void remove(@PathVariable("sid") long stuId) {
		LOG.info("Delete Students");
		dao.deleteById(stuId);
	}
}
