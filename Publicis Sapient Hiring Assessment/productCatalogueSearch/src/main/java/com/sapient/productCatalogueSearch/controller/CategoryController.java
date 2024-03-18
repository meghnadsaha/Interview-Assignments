package com.sapient.productCatalogueSearch.controller;


import com.sapient.productCatalogueSearch.domain.Category;
import com.sapient.productCatalogueSearch.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAllCategories () {
        return categoryService.getAllCategories();
    }

    @PostMapping("/")
    public Category addCategory ( @RequestBody Category category ) {
        return categoryService.addCategory(category);
    }
}
