package com.example.productsservice.repositories.product;

import com.example.productsservice.dto.ProductDTO;
import com.example.productsservice.entity.ProductCategory;
import com.example.productsservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductRepositoryImp {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CrudProductRepository crudProductRepository;

    public void saveProduct(Product product){
        entityManager.persist(product);
    }

    public void saveCategory(ProductCategory category){
        entityManager.persist(category);
    }

    public long allProduct(){
        return productRepository.count();
    }

    public Product findByName(String name){
        return productRepository.findByName(name);
    }

    public Product findById(Long id){
      return productRepository.findProductByIdIs(id);
    }



    public List<ProductDTO> searchAndPaginationProductDTOOrderByPrice(String keyWord, int firstResult , int  maxResult  , String descOrAsc ){

        @SuppressWarnings("unchecked")
        List<ProductDTO> productDTOList =  entityManager
                .createQuery(
                        "select new " +
                                "   com.example.productsservice.dto.ProductDTO( " +
                                "       p.id, p.name, " +
                                "       p.description, p.price, c.nameOfCategory " +
                                "   ) " +
                                "from Product p " +
                                "join p.category c " +
                               "where p.name like:name or p.category.nameOfCategory  LIKE:category "+
                                "order by p.price "+descOrAsc)
                .setParameter("category",keyWord.toLowerCase()+"%")
                .setParameter("name",keyWord.toLowerCase()+"%")
                .setFirstResult(firstResult)
                .setMaxResults(maxResult)
                .getResultList();

        return productDTOList;
    }

    public List<Product> paginationProductOrderByPrice(String keyWord ,int firstResult ,int  maxResult  , String descOrAsc ){

        @SuppressWarnings("unchecked")
        List<Product> productDTOList =  entityManager
                .createQuery(
                        "select p "+
                                "from Product p " +
                                "join p.category c " +
                                "where p.name like:name or p.category.nameOfCategory  LIKE:category "+
                                "order by p.price "+descOrAsc)
                .setParameter("category",keyWord+"%")
                .setParameter("name",keyWord+"%")
                .setFirstResult(firstResult)
                .setMaxResults(maxResult)
                .getResultList();

        return productDTOList;
    }


//    public List<ProductDTO> paginationProductDTO(int  maxResult , int firstResult ){
//        return entityManager
//                .createQuery(
//                        "select new " +
//                                "   com.example.productsservice.dto.ProductDTO( " +
//                                "       p.id, p.name, " +
//                                "       p.description, p.price, c.nameOfCategory " +
//                                "   ) " +
//                                "from Product p " +
//                                "join p.category c " +
//                                "order by p.id")
//                .setFirstResult(firstResult)
//                .setMaxResults(maxResult)
//                .getResultList();
//    }

    public List<ProductDTO> getPageableProduct(int pageNum , int pageSize  , String keyWord){
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);


        Page<ProductDTO> page = productRepository.findProductByNameOrCategoryOrCompany(pageable,keyWord.toLowerCase()+"%" );
        List<ProductDTO> products = page.getContent();
        int totalPage= page.getTotalPages();
        return products;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
