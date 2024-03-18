package com.sapient.productCatalogueSearch.service;

import com.sapient.productCatalogueSearch.domain.Category;
import com.sapient.productCatalogueSearch.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Add more methods as needed
}