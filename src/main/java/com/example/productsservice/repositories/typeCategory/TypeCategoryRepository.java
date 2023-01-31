package com.example.productsservice.repositories.typeCategory;

import com.example.productsservice.entity.TypeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TypeCategoryRepository extends JpaRepository<TypeCategory , Long> {

    @Query(value = "select p.nameOfCategory " +
            "from typies c join c.categoryList p where c.nameOfTypeCategory like:name")
    public List<String> getByDescription(@Param("name") String name);



//
//    @Query(value = "select p.nameOfCategory " +
//            "from typies c join c.categoryList p where c.id like:id")
//    public List<String> getAllCategoryByTypeId(@Param("id") Long id);


}
