package main.api.services;

import lombok.AllArgsConstructor;
import main.api.controllers.ControllerAdvice;
import main.api.dto.DTOMessage;
import main.api.dto.DTOSuccessfully;
import main.api.entitys.List;
import main.api.entitys.Product;
import main.api.repo.ListRepo;
import main.api.repo.ProductRepo;
import main.api.response.ListWithProductsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@Service
public class ListService {
    @Autowired
    private ListRepo listRepo;
    @Autowired
    private ProductRepo productRepo;

    public ResponseEntity<?> findByLongId(long id) {
        if (!listRepo.findByLongId(id).isEmpty())
        {
            return new ResponseEntity<>(listRepo.findByLongId(id).get(0), HttpStatus.OK);
        }
        else {
            return new ControllerAdvice().noSuchElementException();
        }
    }

    public ResponseEntity<?> findByIdAndGetTotalKCal(long id) {
        if (!listRepo.findByLongId(id).isEmpty())
        {
            List list = listRepo.findByLongId(id).get(0);
            return new ResponseEntity<>(new ListWithProductsResponse(list.getLongId(), list.getName(), list.getProductList()),
                    HttpStatus.OK);
        }
        else {
            return new ControllerAdvice().noSuchElementException();
        }
    }

    public java.util.List<List> findAll() {
        Iterable<List> iterable = listRepo.findAll();
        java.util.List<List> listList = new ArrayList<>();
        for (List list : iterable) {
            listList.add(list);
        }
        return listList;
    }

    public List addNewList(long id, String name, ArrayList<Product> products) {
        List newList = new List();
        newList.setLongId(id);
        newList.setName(name);
        newList.setProductList(products);
        listRepo.insert(newList);
        return newList;
    }

    public ResponseEntity<?> addNewList(String name) {
        List newList = new List();
        newList.setName(name);
        listRepo.insert(newList);
        return new ResponseEntity<>(new DTOSuccessfully(null, new Date().getTime() / 1000, new DTOMessage()), HttpStatus.OK);
    }

    public ResponseEntity<?> addProductToList(long productId, long listId) {
        if (listRepo.findById(listId).isPresent()) {
            List currentList = listRepo.findById(listId).get();
            java.util.List<Product> changedProductList = currentList.getProductList();
            if (productRepo.findById(productId).isPresent()) {
                changedProductList.add(productRepo.findById(productId).get());
            }
            currentList.setProductList(changedProductList);
            return new ResponseEntity<>(currentList, HttpStatus.OK);
        }
        return new ControllerAdvice().noElementsException();
    }
}
