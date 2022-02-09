package main;

import main.api.entitys.List;
import main.api.entitys.Product;
import main.api.repo.ListRepo;
import main.api.repo.ProductRepo;
import main.api.services.NextSequenceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(MongoTemplate mongoTemplate, ListRepo listRepo, ProductRepo productRepo, NextSequenceService nextLongId) {
		return args -> {
			Product newProduct1 = new Product(nextLongId.getNextSequence("sequences_for_products"),
					"Potato",
					"White Krasnodar Potato",
					100);
			Product newProduct2 = new Product(nextLongId.getNextSequence("sequences_for_products"),
					"Tomato",
					"Red chili Tomato",
					20);
			Product newProduct3 = new Product(nextLongId.getNextSequence("sequences_for_products"),
					"WasserMelone",
					"Astrakhan WasserMelone",
					250);
			java.util.List<Product> productList = new ArrayList<>() {
				{
					add(newProduct1);
					add(newProduct2);
					add(newProduct3);
				}
			};

			List newList = new List(nextLongId.getNextSequence("sequences_for_list_of_products"),
					"firstList",
					productList);

			productRepo.insert(newProduct1);
			productRepo.insert(newProduct2);
			productRepo.insert(newProduct3);
			listRepo.insert(newList);
		};
	}
}
