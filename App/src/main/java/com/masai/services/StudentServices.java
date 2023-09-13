package com.masai.services;

import com.masai.entity.Student;
import com.masai.exceptation.StudentExceptation;

public interface StudentServices {
	
	//CRUD
	
	public Student saveStudent(Student student);
	
	public Student getStudentbyId(Integer id) throws StudentExceptation;
	
	public Student updateStudetnDetails(Student student) throws StudentExceptation;
	
	public Student deleteStudentDetailsByID(Integer id) throws StudentExceptation;
	

}
