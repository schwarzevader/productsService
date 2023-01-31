package com.example.productsservice.controller;


import com.example.productsservice.repositories.Category.CategoryRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class SortByCategoryController {

    @Autowired
    private CategoryRepositoryImp categoryRepositoryImp;


}
