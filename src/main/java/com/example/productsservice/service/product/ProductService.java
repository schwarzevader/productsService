package com.example.productsservice.service.product;


import com.example.productsservice.entity.Product;
import com.example.productsservice.repositories.product.CrudProductRepository;
import com.example.productsservice.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductService {
//пагинация сортировка по цене по категорям по типу по компании
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ProductRepository productRepository;


    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public void delProduct(Product product){
        productRepository.delete(product);
    }

    public void delProductById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> getProdList(){
        int page = 1;
        return entityManager.createQuery(
                        "select p " +
                                "from Product p " +
                                "where p.name like :name",
                        Product.class)
                .setParameter("name", "J%")
                .setFirstResult(page*10)
                .setMaxResults(10)
                .getResultList();
    }

    public Page<Product> listAll(int pageNum) {
        int pageSize = 5;

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        return productRepository.findAll(pageable);
    }
}
