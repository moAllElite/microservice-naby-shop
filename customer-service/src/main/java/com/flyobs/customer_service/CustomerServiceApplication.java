package com.flyobs.customer_service;

import com.flyobs.customer_service.entities.Customer;
import com.flyobs.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return  args ->{
			customerRepository.save(
					Customer.builder()
							.name("momo dieng")
							.email("momo@gmail.com")
							.build()
			);
			customerRepository.save(
					Customer.builder()
							.name("john cena")
							.email("cena@gmail.com")
							.build()
			);

			customerRepository.findAll().forEach(
					customer -> {
						System.out.println("**************** " );
						System.out.println("name: " + customer.getName());
						System.out.println("email: " + customer.getEmail());

					}
			);
		};
	}
}
