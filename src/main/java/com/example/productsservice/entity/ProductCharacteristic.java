package com.example.productsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity(name = "productCharacteristic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "public" ,name = "product_characteristics")
public class ProductCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "productCharacteristic_id")
    private Long id;

    private String name;

    private String value;

    @OneToMany(	mappedBy = "productCharacteristic",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ProductCharacteristicItem> productCharacteristicItemList = new ArrayList<>();

    @Override
    public String toString() {
        return "ProductCharacteristic{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductCharacteristic product = (ProductCharacteristic) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
