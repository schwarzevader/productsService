package com.example.productsservice.dto;

import com.example.productsservice.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ListProductDTO {

    private String keyWord ;


    //SELECT age, COUNT(*) FROM campers
    private long countOfProduct;
    private List<ProductDTO> productDTOList = new ArrayList<>();

    public void setCountOfProduct(long countOfProduct) {
        this.countOfProduct = countOfProduct;
    }

    public void setProductDTOList(List<ProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }

    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public long getCountOfProduct() {
        return countOfProduct;
    }


}
