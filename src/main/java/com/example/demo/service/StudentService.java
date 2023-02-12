package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addStudents(Student student) {
		Optional<Student> studentByName =  studentRepository.findStudentByName(student.getName());
		
		if(studentByName.isPresent()) {
			throw new IllegalStateException("name taken !!");
		}
		
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		Boolean isStudentExist = studentRepository.existsById(studentId);
		
		if(!isStudentExist) {
			throw new IllegalStateException("student with id"+studentId+"doesnt exist");
		}
		
		studentRepository.deleteById(studentId);
		
	}
	
	@Transactional
	public void updateStudent(Long studentId, String name) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow( () -> new IllegalStateException("student with id : "+studentId+"doesnt exist"));
		
		if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		
	}


}
