package com.medicare.Medicare.service.impl;

import com.medicare.Medicare.entity.medicare.Category;
import com.medicare.Medicare.repository.CategoryRepository;
import com.medicare.Medicare.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long catId,Category category) {
        Optional<Category> categoryUpdated = this.categoryRepository.findById(catId);
        Category categoryNew = categoryUpdated.get();
        categoryNew.setDescription(category.getDescription());
        categoryNew.setTitle(category.getTitle());;
        return this.categoryRepository.save(categoryNew);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }
}
