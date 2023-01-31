package com.example.productsservice.repositories.product;


import com.example.productsservice.dto.ProductDTO;
import com.example.productsservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

//product DTO

//    @Query(value = """
//            select new ProductDto(
//                p.id as id,
//                p.name as name,
//                p.description as description,
//                p.price as price,
//                c.companyName as companyName
//                )
//            from Product p
//            join p.category c
//            where p.name like :postTitle
//            order by p.id
//            """)
//    List<ProductDto> findCommentDTOByTitle(
//            @Param("postTitle") String postTitle
//    );


//    @Query(value = """
//            select p
//            from Product p
//            join p.category c
//            where CONCAT(p.category.nameOfCategory ,' ',p.name ) LIKE %?1%
//            order by p.price desc """)
//    Page<Product> findProductByNameOrCategoryOrCompany(Pageable pageable, String product);


    //WHERE p.category.nameOfCategory LIKE:categoryName or p.name LIKE:productName


//    @Query(value = """
//            select  new com.example.productsservice.dto.ProductDTO(
//                p.id as id,
//                p.name as name,
//                p.description as description,
//                p.price as price,
//                c.nameOfCategory as nameOfcategory)
//            from Product p
//            join p.category c
//            where CONCAT(p.category.nameOfCategory ,' ',p.name ) LIKE %?1%
//
//            order by p.price desc """)
//    Page<ProductDTO> findProductByNameOrCategoryOrCompany(Pageable pageable, String productName );


    @Query(value = """
            select  new com.example.productsservice.dto.ProductDTO(
                p.id as id,
                p.name as name,
                p.description as description,
                p.price as price,
                c.nameOfCategory as nameOfcategory)
            from Product p
            join p.category c
            where CONCAT(p.category.nameOfCategory ,' ',p.name ) LIKE %?1%
            
            order by p.price desc """)
    Page<ProductDTO> findProductByNameOrCategoryOrCompany(Pageable pageable, String productName );


//    @Query(value = """
//            select new com.example.productsservice.dto.ProductDTO(
//                p.id as id,
//                p.name as name,
//                p.description as description,
//                p.price as price,
//                c.nameOfCategory as nameOfcategory)
//            from Product p
//            join p.category c
//            where CONCAT(p.name , p.category.nameOfCategory ,p.category.companyName) LIKE %?1%
//            order by p.price desc """)
//    List<ProductDTO> findProductByNameOrCategoryOrCompany(Pageable pageable,String postTitle);

//    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
//            + " OR p.category.nameOfCategory LIKE %?1%"
//            + " OR p.category.companyName LIKE %?1%")
    @Query(value = "SELECT p FROM Product p WHERE CONCAT(p.name , p.category.nameOfCategory ,p.company.companyName) LIKE %?1%")
    public List<Product> findProductByNameOrCategory(String keyword, Pageable pageable);

    //public List<Product> paginationProductList(int firstResult , int maxPageResult);

    public Product findByName(String name);
    public Product findProductByIdIs(Long id);
}
