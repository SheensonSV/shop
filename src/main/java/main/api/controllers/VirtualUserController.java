package main.api.controllers;

import main.api.entitys.Product;
import main.api.repo.ProductRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@NoArgsConstructor
@Controller
public class VirtualUserController {
//    @Autowired
    private ProductRepo productRepo;

    @Autowired
    public VirtualUserController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void addingProducts(){

        if (productRepo == null) {
            productRepo.save(new Product("Tomato", "From Krasnodar", 100));
            productRepo.save(new Product("Potato", "From Krasnodar", 120));
            productRepo.save(new Product("Watermelon", "From Astrakhan", 300));
            productRepo.save(new Product("Ketchup", "From fresh tomato", 200));
            productRepo.save(new Product("Myones", "With quail's eggs", 500));
            productRepo.save(new Product("Sugar", "From Krasnodar", 400));
            productRepo.save(new Product("Korn", "From Krasnodar", 240));
            productRepo.save(new Product("Mineral Water", "From Baku", 10));
            productRepo.save(new Product("Beer", "Chech Republic", 310));
            productRepo.save(new Product("Tea", "From India", 50));
        }
    }
}
