package com.example.flowershop.repository;

import com.example.flowershop.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    CategoryEntity findById(int id);
}
