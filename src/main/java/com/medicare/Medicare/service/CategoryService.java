package com.medicare.Medicare.service;

import com.medicare.Medicare.entity.medicare.Category;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Long catId, Category category);
    public Set<Category> getCategories();
    public Category getCategory(Long categoryId);
    public void deleteCategory(Long categoryId);
}
