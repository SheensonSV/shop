package com.someshop.entitys;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class List {
    @Id
    private long id;
    private String name;
}
