package com.checkconsumer.kafkaconsumer.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.checkconsumer.kafkaconsumer.model.Students;

public interface ElasticRepository extends ElasticsearchRepository<Students, Integer> {

}
