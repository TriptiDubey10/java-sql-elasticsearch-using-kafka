package com.checkconsumer.kafkaconsumer.kafkaconfig;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.checkconsumer.kafkaconsumer.model.Students;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

	
	@Bean
	public ConsumerFactory<String, Students> consumerFactory() {

		 JsonDeserializer<Students> deserializer = new JsonDeserializer<>(Students.class);
		    deserializer.setRemoveTypeHeaders(false);
		    deserializer.addTrustedPackages("*");
		    deserializer.setUseTypeMapperForKey(true);
		
		Map<String, Object> config = new HashMap<>();
		System.out.print("config call 1");

		 config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		    config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "groupId"); 
		System.out.print("config call 2");
		return new DefaultKafkaConsumerFactory<String, Students>(config, new StringDeserializer(),deserializer);
	}

	    
	    
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Students> kafkaListenerContainerFactory() {
		System.out.print("call Listener");
		ConcurrentKafkaListenerContainerFactory<String, Students> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
	
	
	
