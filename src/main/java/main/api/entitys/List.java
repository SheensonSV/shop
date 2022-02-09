package main.api.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "list_of_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class describes list of products in shop")
public class List {

    @ApiModelProperty(notes = "Unique identifier of the Product.",
            example = "1", required = true, position = 0)
    @Id
    private String id;

    @Indexed(name = "long_id")
    private long longId;

    @ApiModelProperty(notes = "Name of the list.",
            example = "Fruits", required = true, position = 1)
    private String name;

    @ApiModelProperty(notes = "List of products.",
            example = "{}", required = true, position = 2)
    private java.util.List<Product> productList;

    public List(String name, java.util.List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }

    public List(long longId, String name, java.util.List<Product> productList) {
        this.longId = longId;
        this.name = name;
        this.productList = productList;
    }
}
