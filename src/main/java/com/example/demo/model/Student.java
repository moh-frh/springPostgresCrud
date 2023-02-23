package com.example.demo.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
//@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
//@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@SequenceGenerator(
			name="student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
    @GeneratedValue(
    		strategy = GenerationType.SEQUENCE,
    		generator = "student_sequence"
    		)
	
    private Long id;
	private String name;
	private Integer age;

//public Student() {}
//
public Student(Long id, String name) {
	this.id = id;
	this.name = name;
}
//
public Student(String name) {
	this.name = name;
}
//
//public Long getId() {
//	return id;
//}
//
//public void setId(Long id) {
//	this.id = id;
//}
//
//public String getName() {
//	return name;
//}
//
//public void setName(String name) {
//	this.name = name;
//}
//
//
//
//public Integer getAge() {
//	return 1997;
//}
//
//public void setAge(Integer age) {
//	this.age = age;
//}
//
//@Override
//public String toString() {
//	return "Student [id=" + id + ", name=" + name + "]";
//}


}
