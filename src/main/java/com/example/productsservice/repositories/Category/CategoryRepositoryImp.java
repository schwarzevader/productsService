package com.example.productsservice.repositories.Category;


import com.example.productsservice.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryRepositoryImp {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CrudCategory crudCategory;

    public void saveCategory(ProductCategory category){
        crudCategory.save(category);
    }

    public void deleteCategory(Long id){
        crudCategory.deleteById(id);
    }
    @SuppressWarnings("unchecked")
    public List<String> paginationCategoryDTO(){
        return entityManager.createQuery
                        ("select c.nameOfCategory from ProductCategory c ")
                .getResultList();
    }


    public List<String> getCategoryNameByTypeCategory(String name){
        return crudCategory.getCategoriesNameByTypeCategory(name);
    }



}
