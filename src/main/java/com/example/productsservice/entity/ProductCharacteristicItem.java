package com.example.productsservice.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "productCharacteristicItem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "public" ,name = "product_characteristics_item")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = ProductCharacteristicItem.class,
        resolver =EntityIdResolver.class
)
public class ProductCharacteristicItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_characteristic_id")
    private ProductCharacteristic productCharacteristic;



}
