package com.flyobs.inventory_service;

import com.flyobs.inventory_service.entities.Product;
import com.flyobs.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args ->{
			productRepository.save(
					Product.builder()
							.id(UUID.randomUUID().toString())
							.name("techno spark 30")
							.price(120000)
							.quantity(2)
							.build()
			)	;
			productRepository.save(
					Product.builder()
							.id(UUID.randomUUID().toString())
							.name("samsung")
							.price(400000)
							.quantity(2)
							.build()
			)	;
		};
	}
}
