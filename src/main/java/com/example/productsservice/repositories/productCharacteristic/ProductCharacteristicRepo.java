package com.example.productsservice.repositories.productCharacteristic;

import com.example.productsservice.entity.ProductCharacteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductCharacteristicRepo extends JpaRepository<ProductCharacteristic, Long> {

//    @Query(value = "select p from productCharacteristic p where p.id LIKE:name")
//    public ProductCharacteristic find(@Param("name") Long id);

   // @Query(value = "select p from productCharacteristic p WHERE p.id LIKE:name")
    public ProductCharacteristic findProductCharacteristicById(Long id);
    public ProductCharacteristic findProductCharacteristicByName(String name);
}
