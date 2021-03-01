package com.kafka.demo;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.Properties;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

		Properties prop = new Properties();
		prop.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:2181");
		AdminClient admin = AdminClient.create(prop);

		admin.close(Duration.ofSeconds(30));



	}

}
