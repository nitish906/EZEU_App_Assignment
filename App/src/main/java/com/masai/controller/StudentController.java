package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Student;
import com.masai.exceptation.StudentExceptation;
import com.masai.services.StudentServices;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServices services;
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudetnHandler(@RequestBody Student student){
		
		Student createstd= services.saveStudent(student);
		
		return new ResponseEntity<Student>(createstd, HttpStatus.CREATED);
		
	}
	
	@GetMapping("student/{id}")
	public ResponseEntity<Student> findStudentByIdHandler(@PathVariable("id") Integer id) throws StudentExceptation{
		
		Student findstd= services.getStudentbyId(id);
		
		return new ResponseEntity<Student>(findstd, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student)throws StudentExceptation{
		Student updatestd= services.updateStudetnDetails(student); 
		
		return new ResponseEntity<Student>(updatestd, HttpStatus.OK);
	}
	
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<Student> deleteStudentHandler(@PathVariable("id") Integer id)throws StudentExceptation{
		 Student deleStudent= services.deleteStudentDetailsByID(id); 
		
		return new ResponseEntity<Student>(deleStudent,HttpStatus.OK);
		
	}

}
