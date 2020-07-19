package com.example.restaurant.application;

import com.example.restaurant.domain.Category;
import com.example.restaurant.domain.CategoryRepository;
import com.example.restaurant.domain.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class CategoryServiceTests {

    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void getCategoies() {
        List<Category> mockCategories = new ArrayList<>();
        mockCategories.add(Category.builder().name("Korean Food").build());

        given(categoryRepository.findAll()).willReturn(mockCategories);

        List<Category> categories = categoryService.getCategoies();

        Category category = categories.get(0);

        assertThat(category.getName()).isEqualTo("Korean Food");
    }

    @Test
    public void addCategory() {
        Category category = categoryService.addCategory("Korean Food");

        verify(categoryRepository).save(any());

        assertThat(category.getName()).isEqualTo("Korean Food");
    }
}