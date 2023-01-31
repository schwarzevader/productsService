package com.example.productsservice.repositories.productCharacteristicItem;

import com.example.productsservice.dto.ProductDTO;
import com.example.productsservice.entity.Product;
import com.example.productsservice.entity.ProductCharacteristicItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductCharacteristicItemRepo
        extends JpaRepository<ProductCharacteristicItem,Long> {
    @Query(value = "select p from productCharacteristicItem pCi " +
            "join pCi.product p join pCi.productCharacteristic pCh " +
            "where p.category.nameOfCategory like:category and pCh.name like:character " +
            "and pCh.value like:value " +
            " order by p.price desc ")
    public List<Product> getProductByCategoryAndProductCharacteristics(@Param("category") String category,
                                                                       @Param("character") String characteristics,
                                                                       @Param("value")String value);



    @Query(value = """
            select  new com.example.productsservice.dto.ProductDTO(
                p.id as id,
                p.name as name,
                p.description as description,
                p.price as price)
            from  productCharacteristicItem pCi
            join pCi.product p
            join pCi.productCharacteristic pCh
            where p.category.nameOfCategory like:category and pCh.name like:character
            and pCh.value like:value
            order by p.price desc """)
    public Page<ProductDTO> getProductDTOByCategoryAndProductCharacteristics(@Param("category") String category,
                                                                             @Param("character") String characteristics,
                                                                             @Param("value")String value, Pageable pageable);



}
