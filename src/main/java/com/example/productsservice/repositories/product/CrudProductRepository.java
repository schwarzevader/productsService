package com.example.productsservice.repositories.product;


import com.example.productsservice.entity.Product;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface CrudProductRepository extends CrudRepository<Product,Long> {
    
}
