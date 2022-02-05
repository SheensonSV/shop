package com.someshop.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Class describes list of products in shop")
public class List {

    @ApiModelProperty(notes = "Unique identifier of the Product.",
            example = "1", required = true, position = 0)
    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(notes = "Name of the list.",
            example = "Fruits", required = true, position = 1)
    private String name;

    private java.util.List<Product> productList;

    private int sumOfkCal;

    public List(String name, java.util.List<Product> productList, int sumOfkCal) {
        this.name = name;
        this.productList = productList;
        this.sumOfkCal = sumOfkCal;
    }
}
