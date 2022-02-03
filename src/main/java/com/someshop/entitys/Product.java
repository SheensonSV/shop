package com.someshop.entitys;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {
    @Id
    private long id;
    private String name;
    private String description;
    private int kcal;

}
