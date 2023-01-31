package com.example.productsservice.service.typeCategory;

import com.example.productsservice.entity.TypeCategory;
import com.example.productsservice.repositories.typeCategory.TypeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeCategoryService {
    @Autowired
    private TypeCategoryRepository typeCategoryRepository;

    public void save(TypeCategory typeCategory){
        typeCategoryRepository.save(typeCategory);
    }

    public List<String> getCategoryNameByTepeCategorryName(String name){
        return typeCategoryRepository.getByDescription(name);
    }


}
