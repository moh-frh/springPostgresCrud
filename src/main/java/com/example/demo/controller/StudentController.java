package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(path = "api/student")

public class StudentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	} 
	
	@GetMapping
	public List<Student> getStudents() {
		LOGGER.info("azertyui");
		return studentService.getStudents();
	}
	
	@PostMapping
	public void registerStudent(@RequestBody Student student) {
		studentService.addStudents(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}
	
//	http://localhost:8080/api/student/1?name=ffff
	@PutMapping(path = "{studentId}")
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String name
			) {
		studentService.updateStudent(studentId, name);
	}

}
