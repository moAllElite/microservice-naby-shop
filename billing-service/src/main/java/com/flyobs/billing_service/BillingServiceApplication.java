package com.flyobs.billing_service;

import com.flyobs.billing_service.entities.Bill;
import com.flyobs.billing_service.entities.ProductItem;
import com.flyobs.billing_service.feign.CustomerRestClient;
import com.flyobs.billing_service.feign.ProductRestClient;
import com.flyobs.billing_service.models.Customer;
import com.flyobs.billing_service.models.Product;
import com.flyobs.billing_service.repositories.BillRepository;
import com.flyobs.billing_service.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@EnableFeignClients
@SpringBootApplication
public class BillingServiceApplication {
	private  static final Random random = new Random();
	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient
	){

		Collection<Customer> customers = customerRestClient.findAllCustomers()
				.getContent() ;
		Collection<Product> products = productRestClient.getAllProducts().getContent();
		return args -> customers.forEach(
                customer -> {
                    Bill bill = Bill.builder()
                            .billingDate(new Date())
                            .customerId(customer.getId())
                            .build();
                    billRepository.save(bill);
                    products.forEach(product -> {
                        ProductItem productItem = ProductItem.builder()
                                .productId(product.getId())
                                .bill(bill)
                                .quantity(1 + random.nextInt(10))
                                .unitPrice(product.getPrice())
                                .build();
                        productItemRepository.save(productItem);
                    });

                });
	}
}
