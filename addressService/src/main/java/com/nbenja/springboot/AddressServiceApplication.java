package com.nbenja.springboot;

import com.nbenja.springboot.domain.Address;
import com.nbenja.springboot.repository.AddressRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

@SpringBootApplication
public class AddressServiceApplication {

	@Bean
	public CommandLineRunner commandLineRunner(AddressRepository addressRepository) {
		return args -> {
			addressRepository.findAll().forEach(System.out:: print);
		};
	}
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
	}

	@Bean
	public JdbcTemplate readJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}
}
