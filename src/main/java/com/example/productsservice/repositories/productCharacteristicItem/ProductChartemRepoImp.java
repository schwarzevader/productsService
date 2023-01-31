package com.example.productsservice.repositories.productCharacteristicItem;

import com.example.productsservice.entity.Product;
import com.example.productsservice.entity.ProductCharacteristicItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductChartemRepoImp {


//    @Query(value = """
//            select  new com.example.productsservice.dto.ProductDTO(
//                p.id as id,
//                p.name as name,
//                p.description as description,
//                p.price as price)
//            from productCharacteristicItem pci
//            join pci.product p
//            join pci.productCharacteristic
//            where pci.productCharacteristic.name LIKE %?1%
//            order by p.price desc """)
//    public Page<ProductDTO> findByProductCharacteristics(Pageable pageable, String characteristics);


    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ProductCharacteristicItemRepo productCharacteristicItemRepo;


    public void save(ProductCharacteristicItem productCharacteristicItem) {
        entityManager.persist(productCharacteristicItem);
    }

    public void saveItem(ProductCharacteristicItem productCharacteristicItem){
        entityManager.persist(productCharacteristicItem);
    }



    public List<Product> getProductDTOByCategoryAndProductCharacteristics(String category, String characteristics,
                                                                          String value){
        return productCharacteristicItemRepo.getProductByCategoryAndProductCharacteristics(category,characteristics,value);
    }

}
