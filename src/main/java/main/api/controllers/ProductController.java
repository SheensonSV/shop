package main.api.controllers;

import main.api.dto.DTOMessage;
import main.api.dto.DTOSuccessfully;
import main.api.entitys.Product;
import main.api.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        if (productRepo.existsById(id))
        {
            Product product = productRepo.findById(id).get();
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        else {
            return new main.api.controllers.ControllerAdvice().noSuchElementException();
        }
    }

    @GetMapping("/getallproducts")
    public ResponseEntity<?> getAllProducts() {
        List<Product> actualList = new ArrayList<>();
        Iterator<Product> iterator = productRepo.findAll().iterator();
        if (!iterator.hasNext())
        {
            return new main.api.controllers.ControllerAdvice().noElementsException();
        }
        iterator.forEachRemaining(actualList::add);
        return new ResponseEntity<>(actualList, HttpStatus.OK);
    }

    @PostMapping("/addnewproduct")
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
        productRepo.save(product);

        return ResponseEntity.ok(new DTOSuccessfully(null, new Date().getTime() / 1000, new DTOMessage()));
    }

    @PutMapping("/changeproduct/$id")
    public ResponseEntity<?> changeExistedProduct(@RequestBody Product product) {
        if (productRepo.existsById(product.getId())) {
            productRepo.save(product);
            return ResponseEntity.ok(new DTOSuccessfully(null, new Date().getTime() / 1000, new DTOMessage()));
        }
        else {
            return new ControllerAdvice().noSuchElementException();
        }
    }
}
