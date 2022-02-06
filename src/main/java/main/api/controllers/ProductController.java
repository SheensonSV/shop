package main.api.controllers;

import main.api.dto.DTOMessage;
import main.api.dto.DTOSuccessfully;
import main.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        return productService.findById(id);
    }

    @GetMapping("/getallproducts")
    public ResponseEntity<?> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/addnewproduct")
    public ResponseEntity<?> addNewProduct(@RequestBody String name, @RequestBody String description, @RequestBody int kCal) {
        productService.addProduct(name, description, kCal);

        return ResponseEntity.ok(new DTOSuccessfully(null, new Date().getTime() / 1000, new DTOMessage()));
    }

    @PutMapping("/changeproduct/{id}")
    public ResponseEntity<?> changeExistedProduct(@RequestParam long id,
                                                  @RequestBody String name,
                                                  @RequestBody String description,
                                                  @RequestBody int kCal) {
        return productService.changeProductById(id, name, description, kCal);
    }
}
