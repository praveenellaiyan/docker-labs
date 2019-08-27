package com.praveenellaiyan.multicontainerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.praveenellaiyan.dao.CustomerRepository;
import com.praveenellaiyan.model.Customer;

@SpringBootApplication(scanBasePackages = "com.praveenellaiyan")
@EnableJpaRepositories(basePackageClasses = {CustomerRepository.class})
@EntityScan(basePackageClasses = {Customer.class})
public class MulticontainerappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MulticontainerappApplication.class, args);
	}

}
