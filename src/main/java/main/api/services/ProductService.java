package main.api.services;

import main.api.controllers.ControllerAdvice;
import main.api.entitys.Product;
import main.api.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private static final NextSequenceService nextSequenceService = new NextSequenceService();

    /**
     *
     * First initialisation
     * adding data to MongoDB

    private static java.util.List<Product> productsList = new ArrayList<>();
    static {
        productsList.add(new Product(0,"Tomato", "From Krasnodar", 100));
        productsList.add(new Product(1,"Potato", "From Krasnodar", 120));
        productsList.add(new Product(2,"Watermelon", "From Astrakhan", 300));
        productsList.add(new Product(3,"Ketchup", "From fresh tomato", 200));
        productsList.add(new Product(4,"Mayonees", "With quail's eggs", 500));
        productsList.add(new Product(5,"Sugar", "From Krasnodar", 400));
        productsList.add(new Product(6,"Korn", "From Krasnodar", 240));
        productsList.add(new Product(7,"Mineral Water", "From Baku", 10));
        productsList.add(new Product(8,"Beer", "Chech Republic", 310));
        productsList.add(new Product(9,"Tea", "From India", 50));
    }

    @PostConstruct
    public void init() {
        productRepo.saveAll(productsList);
    }
     */
    public java.util.List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product addProduct(String name, String description, int kCal) {
        Product newProduct = new Product(name, description, kCal);
        newProduct.setId(nextSequenceService.getNextSequence("sequences"));
        productRepo.save(newProduct);
        return newProduct;
    }

    public Product findById(long id) {
        if (productRepo.findById(id).isPresent())
        {
            return productRepo.findById(id).get();
        }
        else {
            return null;
        }
    }

    public java.util.List<Product> findByName(String name) {
        java.util.List<Product> productList = new ArrayList<>();
        productList = productRepo.findProductByName(name);
        return productList;
    }

    public ResponseEntity<?> changeProduct(Product product) {
        if (productRepo.findById(product.getId()).isPresent()) {
            Product oldProduct = productRepo.findById(product.getId()).get();
            oldProduct.setDescription(product.getDescription());
            oldProduct.setName(product.getName());
            oldProduct.setKcal(product.getKcal());
            productRepo.save(oldProduct);
            return new ResponseEntity<>(oldProduct, HttpStatus.OK);
        }
        else {
            return new ControllerAdvice().noSuchElementException();
        }
    }
}
