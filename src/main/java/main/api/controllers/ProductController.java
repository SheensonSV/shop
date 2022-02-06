package main.api.controllers;

import main.api.dto.DTOMessage;
import main.api.dto.DTOSuccessfully;
import main.api.entitys.Product;
import main.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/getallproducts")
    public ResponseEntity<?> getAllProducts() {
        List<Product> actualList = new ArrayList<>();
        Iterator<Product> iterator = productService.findAll().iterator();
        if (!iterator.hasNext())
        {
            return new main.api.controllers.ControllerAdvice().noElementsException();
        }
        iterator.forEachRemaining(actualList::add);
        return new ResponseEntity<>(actualList, HttpStatus.OK);
    }

    @PostMapping("/addnewproduct")
    public ResponseEntity<?> addNewProduct(@RequestBody String name, @RequestBody String description, @RequestBody int kCal) {
        productService.addProduct(name, description, kCal);

        return ResponseEntity.ok(new DTOSuccessfully(null, new Date().getTime() / 1000, new DTOMessage()));
    }

    @PutMapping("/changeproduct/$id")
    public ResponseEntity<?> changeExistedProduct(@RequestBody Product product) {
        return productService.changeProduct(product);
//        return ResponseEntity.ok(new DTOSuccessfully(null, new Date().getTime() / 1000, new DTOMessage()));
    }
}
