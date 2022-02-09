package main.api.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class describes Product in shop")
public class Product {
    @ApiModelProperty(notes = "Unique identifier of the Product.",
            example = "1", required = true, position = 0)
    @Id
    private String id;

    @Indexed(name = "long_id")
    private long longId;

    @ApiModelProperty(notes = "Name of the product.",
            example = "Tomato", required = true, position = 1)
    private String name;

    @ApiModelProperty(notes = "Description of product.",
            example = "Fresh Tomato from Krasnodar", required = false, position = 2)
    private String description;

    @ApiModelProperty(notes = "Count of Kilocalories.",
            example = "100 kCal", required = false, position = 3)
    private int kcal;
    public Product(String name, String description, int kcal) {
        this.name = name;
        this.description = description;
        this.kcal = kcal;
    }

    public Product(long longId, String name, String description, int kcal) {
        this.longId = longId;
        this.name = name;
        this.description = description;
        this.kcal = kcal;
    }
}
