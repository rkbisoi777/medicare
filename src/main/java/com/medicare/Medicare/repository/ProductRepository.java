package com.medicare.Medicare.repository;

import com.medicare.Medicare.entity.medicare.Category;
import com.medicare.Medicare.entity.medicare.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findByCategory(Category category);
}
