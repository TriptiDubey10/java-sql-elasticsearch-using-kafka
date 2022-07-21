package com.checkconsumer.kafkaconsumer.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkconsumer.kafkaconsumer.model.Students;
import com.checkconsumer.kafkaconsumer.repository.ElasticRepository;

@Service
public class StudentService {
	
	@Autowired
	ElasticRepository elasticrepo;
	
    public Iterable<Students> getAll()
    {
    	return elasticrepo.findAll();
    }
    
    public Students createStudents(Students stu) {
        return elasticrepo.save(stu);
    }
    
    public Iterable<Students> insertBulk(List<Students> stu) {
        return elasticrepo.saveAll(stu);
    }



}
