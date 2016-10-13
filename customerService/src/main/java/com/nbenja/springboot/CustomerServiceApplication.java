package com.nbenja.springboot;

import com.nbenja.springboot.domain.Customer;
import com.nbenja.springboot.repository.CustomerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	private List<Customer> customers = Arrays.asList(
			new Customer("Ryan", "Adam"),
			new Customer("Tom", "Ross")
	);

	@Bean
	public CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customers.forEach(c -> customerRepository.save(c));
			customerRepository.findAll().forEach(System.out:: print);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}
