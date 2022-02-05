package main.api.controllers;

import main.api.entitys.List;
import main.api.repo.ListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;

@RestController
public class ListController {
    @Autowired
    private ListRepo listRepo;

    @GetMapping("/getlistofproduct")
    public ResponseEntity<?> getProductById(long id) {
        if (listRepo.existsById(id))
        {
            List list = listRepo.findById(id).get();
            return new ResponseEntity<List>(list, HttpStatus.OK);
        }
        else {
            return new ControllerAdvice().noSuchElementException();
        }
    }

    @GetMapping("/getalllists")
    public ResponseEntity<?> getAllLists() {
        java.util.List<List> actualList = new ArrayList<>();
        Iterator<List> iterator = listRepo.findAll().iterator();
        iterator.forEachRemaining(actualList::add);
        return new ResponseEntity<>(actualList, HttpStatus.OK);
    }

    @PostMapping("/addnewlist")
    public ResponseEntity<?> addNewListWithProducts() {

        return null;
    }
}
