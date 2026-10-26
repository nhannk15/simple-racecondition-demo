package com.nhannkl.race;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nhannkl.race.model.entity.Product;
import com.nhannkl.race.repository.ProductRepository;

@SpringBootApplication
public class RaceApplication {

    private final ProductRepository productRepository;

    
    @Autowired 
	public RaceApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(RaceApplication.class, args);
	}

    @Bean 
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Product product = new Product(1L, "Macbook Air Force", 10, new BigDecimal("10000"));
            productRepository.save(product);
        };
    }

}
