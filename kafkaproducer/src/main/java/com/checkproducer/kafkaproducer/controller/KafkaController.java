package com.checkproducer.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.checkproducer.kafkaproducer.service.StudentService;
import com.checkproducer.kafkaproducer.studentmodel.Students;

@RestController
public class KafkaController {
	@Autowired
	StudentService stuservice;
	
	@Autowired
	KafkaTemplate<String, Students> kafkaTemplate;

	private static final String TOPIC = "stutopic";
	

	
	@PostMapping("/student")
	private String save(@RequestBody Students stu) {
		
		stu= stuservice.addStudent(stu);
		kafkaTemplate.send(TOPIC, stu);

		return "Successfuly Post";

   }
	

}
