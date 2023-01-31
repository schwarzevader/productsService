package com.example.productsservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

    private Long id;

    private String name;

    private String describe ;

    private double price;
    private String category;

    public ProductDTO(Long id, String name, String describe, double price) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", describe='" + describe + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO that)) return false;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCategory(), that.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getName(),
                getCategory()
        );
    }
}
