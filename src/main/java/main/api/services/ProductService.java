package main.api.services;

import lombok.AllArgsConstructor;
import main.api.controllers.ControllerAdvice;
import main.api.entitys.Product;
import main.api.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public ResponseEntity<?> findAll() {
        Iterable<Product> iterable = productRepo.findAll();
        java.util.List<Product> productList = new ArrayList<>();

        for (Product product : iterable) {
            productList.add(product);
        }
        if (productList.size() != 0) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
        else {
            return new ControllerAdvice().noElementsException();
        }
    }

    public Product addProduct(String name, String description, int kCal) {
        Product newProduct = new Product(name, description, kCal);
        productRepo.insert(newProduct);
        return newProduct;
    }

    public ResponseEntity<?> findByLongId(long id) {
        if (!productRepo.findByLongId(id).isEmpty())
        {
            return new ResponseEntity<>(productRepo.findByLongId(id).get(0), HttpStatus.OK);
        }
        else {
            return new ControllerAdvice().noSuchElementException();
        }
    }

    public ResponseEntity<?> findByName(String name) {
        java.util.List<Product> productList = new ArrayList<>();
        productList = productRepo.findProductByName(name);
        if (!productList.isEmpty()) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
        else {
            return new ControllerAdvice().noElementsException();
        }
    }

    public ResponseEntity<?> changeProduct(Product product) {
        if (!productRepo.findByLongId(product.getLongId()).isEmpty()) {
            Product oldProduct = productRepo.findByLongId(product.getLongId()).get(0);
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

    public ResponseEntity<?> changeProductById(long id, String name, String description, int kCal) {
        if (productRepo.findById(id).isPresent()) {
            Product oldProduct = productRepo.findById(id).get();
            oldProduct.setDescription(description);
            oldProduct.setName(name);
            oldProduct.setKcal(kCal);
            productRepo.save(oldProduct);
            return new ResponseEntity<>(oldProduct, HttpStatus.OK);
        }
        else {
            return new ControllerAdvice().noSuchElementException();
        }
    }
}
