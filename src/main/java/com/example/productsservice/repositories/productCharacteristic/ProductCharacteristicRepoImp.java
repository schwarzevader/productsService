package com.example.productsservice.repositories.productCharacteristic;

import com.example.productsservice.entity.ProductCharacteristic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class ProductCharacteristicRepoImp {

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private ProductCharacteristicRepo productCharacteristicRepo;

    public void save(ProductCharacteristic productCharacteristic){
        productCharacteristicRepo.save(productCharacteristic);
    }

    public ProductCharacteristic findByID(Long id){

      return entityManager.createQuery(
              "SELECT p from productCharacteristic p where p.id=:id",ProductCharacteristic.class)
              .setParameter("id",id).getSingleResult();
     // return   productCharacteristicRepo.findProductCharacteristicById(id);
    }

    public ProductCharacteristic fideByName(String name){
        return productCharacteristicRepo.findProductCharacteristicByName(name);
    }
}
