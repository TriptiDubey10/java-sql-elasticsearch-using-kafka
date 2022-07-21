package com.checkconsumer.kafkaconsumer.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.checkconsumer.kafkaconsumer.model.Students;
import com.checkconsumer.kafkaconsumer.service.StudentService;


@Component
public class Consumer {

	@Autowired
	StudentService service;

	List<Students> message = new ArrayList<>();

	@KafkaListener(topics = "stutopic", groupId = "groupId", containerFactory = "kafkaListenerContainerFactory")
	public void getConsumer(List<Students> stu) {
		service.insertBulk(stu);
		for (Students s : stu) {
			System.out.println(s);
		}

	}

}
