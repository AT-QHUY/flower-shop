package com.example.flowershop.service;

import com.example.flowershop.dto.CategoryDTO;
import com.example.flowershop.model.CategoryEntity;

import java.util.List;

public interface ICategoryService {

    public CategoryDTO findById(int id);

    public List<CategoryDTO> findAll();
}
