package com.example.productsservice.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products",schema = "public")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = Product.class,
        resolver =EntityIdResolver.class
)
//@DynamicUpdate
public class Product  implements Serializable {
//search by name or category or type
//исп фабрику для продуктов с разными характеристиками

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;;

    private String name;

    private String characteristics;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIdentityReference(alwaysAsId = true)
    private ProductCategory category;
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "company_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Company company;
    private double price;
    private String description;
    //private String descriptionForDTO;
    //    private String reviews ;
    private int quantity = 0;


    @OneToMany(	mappedBy = "product",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIdentityReference(alwaysAsId = true)
    private List<ProductCharacteristicItem> productCharacteristicItemList = new ArrayList<>();

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private TypeCategory type ;


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
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
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }




}