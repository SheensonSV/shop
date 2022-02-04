package com.someshop.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
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
}
