package main.api.services;

import main.api.entitys.List;
import main.api.entitys.Product;
import main.api.repo.ListRepo;
import main.api.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class ListService {
    @Autowired
    private ListRepo listRepo;

    /**
     * first initialisation.
     * adding data to mongoDB
     * @return

    private static java.util.List<Product> productsList = new ArrayList<>();
    static {
        productsList.add(new Product(0,"Tomato", "From Krasnodar", 100));
        productsList.add(new Product(1,"Potato", "From Krasnodar", 120));
        productsList.add(new Product(2,"Watermelon", "From Astrakhan", 300));
    }

    @PostConstruct
    public void init() {
        listRepo.save(new List(0, "First list", productsList));
    }
    */
    public java.util.List<List> findAll() {
        return listRepo.findAll();
    }

    public List addNewList(long id, String name, ArrayList<Product> products) {
        List newList = new List();
        newList.setId(id);
        newList.setName(name);
        newList.setProductList(products);
        return newList;
    }
}
