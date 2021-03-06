package com.praveenellaiyan.dockerize.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.praveenellaiyan.dockerize")
public class DockerizeSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerizeSpringbootApplication.class, args);
	}

}
