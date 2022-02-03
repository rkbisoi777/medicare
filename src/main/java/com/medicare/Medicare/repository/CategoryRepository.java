package com.medicare.Medicare.repository;

import com.medicare.Medicare.entity.medicare.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
