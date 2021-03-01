package com.kafka.demo;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		SpringApplication.run(DemoApplication.class, args);

		Properties prop = new Properties();
		prop.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:2181");
		AdminClient admin = AdminClient.create(prop);
		ListTopicsResult topics = admin.listTopics();
		topics.names().get().forEach(System.out::println);
		admin.close(Duration.ofSeconds(30));



	}

}
