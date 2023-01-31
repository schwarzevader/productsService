package com.example.productsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.transform.ResultTransformer;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTOResultSet implements Serializable {

    private Long id;

    private String name;

    private String describe ;

    private double price;
    private String company;



    //private CompanyDTO companyDTO;


    public ProductDTOResultSet(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
