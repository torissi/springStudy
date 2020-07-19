package com.example.restaurant.application;

import com.example.restaurant.domain.Category;
import com.example.restaurant.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategoies() {
        List<Category> categories = categoryRepository.findAll();
        //regions.add(Region.builder().name("Seoul").build());
        return categories;
    }

}
