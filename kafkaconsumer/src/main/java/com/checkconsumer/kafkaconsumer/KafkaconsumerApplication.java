package com.checkconsumer.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = "com.checkproducer.kafkaproducer")
@SpringBootApplication
public class KafkaconsumerApplication {

	public static void main(String[] args) {
		System.out.println("consumer loded");
		SpringApplication.run(KafkaconsumerApplication.class, args);
	}

}
