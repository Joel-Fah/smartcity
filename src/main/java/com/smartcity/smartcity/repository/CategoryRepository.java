package com.smartcity.smartcity.repository;

import com.smartcity.smartcity.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Additional query methods (if any) can be added here
}
