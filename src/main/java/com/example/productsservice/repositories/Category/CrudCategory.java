package com.example.productsservice.repositories.Category;

import com.example.productsservice.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CrudCategory extends JpaRepository<ProductCategory,Long> {

    @Query(value = "select c.nameOfCategory from ProductCategory c join c.typeCategory t where t.nameOfTypeCategory like:name")
    public List<String> getCategoriesNameByTypeCategory(@Param("name") String typeCategory);

    @Query(value = "select c.nameOfCategory from ProductCategory c ")
    public List<String> getCategoriesName(@Param("name") String typeCategory);
}
