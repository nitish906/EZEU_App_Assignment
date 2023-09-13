package com.masai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Student;
import com.masai.exceptation.StudentExceptation;
import com.masai.repositery.StudentDao;

import jakarta.persistence.Id;

@Service
public class StudentServicesImpl implements StudentServices {
	
	@Autowired
	private StudentDao dao;

	@Override
	public Student saveStudent(Student student) {
		Student createStudent= dao.save(student);
		return createStudent;
	}

	@Override
	public Student getStudentbyId(Integer id) throws StudentExceptation {
		Optional<Student>optional=dao.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new StudentExceptation("Student Not Found: "+id);
		}
	}

	@Override
	public Student updateStudetnDetails(Student student) throws StudentExceptation {
		Optional< Student> optional= dao.findById(student.getId());
		
		if(optional.isPresent()) {
			return dao.save(student);
		}
		else {
			throw  new StudentExceptation("Student not Updated");
		}
	}

	@Override
	public Student deleteStudentDetailsByID(Integer id) throws StudentExceptation {
		Optional<Student> optional =dao.findById(id);
		
		Student deleteStdStudent=optional.orElseThrow(()-> new StudentExceptation("Student not Deleted by givin id: "+id));
		dao.delete(deleteStdStudent);
		return deleteStdStudent;
	}
	

}
