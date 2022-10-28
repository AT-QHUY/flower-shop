package com.example.flowershop.converter;

import com.example.flowershop.dto.CategoryDTO;
import com.example.flowershop.dto.FlowerDTO;
import com.example.flowershop.model.CategoryEntity;
import com.example.flowershop.model.FlowerEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {

    public CategoryDTO toDTO(CategoryEntity entity){
        if (entity == null) return null;
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public List<CategoryDTO> toDTO(List<CategoryEntity> entityList){
        if(entityList == null) return null;
        List<CategoryDTO> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(toDTO(entity)));
        return dtoList;
    }

    public CategoryEntity toEntity(CategoryDTO dto){
        if (dto == null) return null;
        CategoryEntity entity = new CategoryEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
