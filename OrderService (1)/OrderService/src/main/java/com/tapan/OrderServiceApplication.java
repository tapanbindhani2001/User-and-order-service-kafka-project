package com.tapan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OrderServiceApplication {

	public static void main(String[] args)
    {
		SpringApplication.run(OrderServiceApplication.class, args);
	}


}

