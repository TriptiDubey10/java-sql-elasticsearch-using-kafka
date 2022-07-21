package com.checkproducer.kafkaproducer.studentrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkproducer.kafkaproducer.studentmodel.Students;

public interface StudentRepository extends JpaRepository<Students, Integer>{

}
