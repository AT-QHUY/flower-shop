package com.example.flowershop.service.impl;

import com.example.flowershop.converter.CategoryConverter;
import com.example.flowershop.dto.CategoryDTO;
import com.example.flowershop.model.CategoryEntity;
import com.example.flowershop.repository.CategoryRepository;
import com.example.flowershop.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryService implements ICategoryService {

    @Autowired
    public CategoryConverter categoryConverter;
    @Autowired
    public CategoryRepository categoryRepository;


    @Override
    public CategoryDTO findById(int id) {
        CategoryEntity entity = categoryRepository.findById(id);
        return categoryConverter.toDTO(entity);
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryEntity> list = categoryRepository.findAll();
        return categoryConverter.toDTO(list);
    }
}
