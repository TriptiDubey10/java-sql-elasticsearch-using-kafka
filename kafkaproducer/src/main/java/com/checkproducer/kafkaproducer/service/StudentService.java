package com.checkproducer.kafkaproducer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkproducer.kafkaproducer.studentmodel.Students;
import com.checkproducer.kafkaproducer.studentrepository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository sturepo;
	
	public List<Students> getAllStudent(){
	   return sturepo.findAll();	
	}
	
	public Students getStudents(int id) {
		return sturepo.findById(id).get();
	}
	
	public Students addStudent(Students stu) {
		
		return sturepo.save(stu);
	}
	
	public void updateStudent(Students stu) {
		sturepo.save(stu);
	}
	
	
}
