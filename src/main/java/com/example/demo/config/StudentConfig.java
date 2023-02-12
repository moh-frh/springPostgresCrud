package com.example.demo.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student s1 = new Student("mohamed");
			Student s2 = new Student("fouaz");
			
			repository.saveAll(
					List.of(s1, s2)
			);
		};
	}

}
