package com.someshop.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@ApiModel(description = "Class describes Product in shop")
public class Product {
    @ApiModelProperty(notes = "Unique identifier of the Product.",
            example = "1", required = true, position = 0)
    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(notes = "Name of the product.",
            example = "Tomato", required = true, position = 1)
    private String name;

    @ApiModelProperty(notes = "Description of product.",
            example = "Fresh Tomato from Krasnodar", required = false, position = 2)
    private String description;
    @ApiModelProperty(notes = "Count of Kilocalories.",
            example = "100 kCal", required = false, position = 3)
    private int kcal;
}
