package com.example.flowershop.converter;

import com.example.flowershop.dto.FlowerDTO;
import com.example.flowershop.model.FlowerEntity;
import com.example.flowershop.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlowerConverter {

    @Autowired
    public CategoryService categoryService;

    @Autowired
    public CategoryConverter categoryConverter;

    public FlowerDTO toDTO(FlowerEntity entity){
        if (entity == null) return null;
        FlowerDTO dto = new FlowerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCategory(categoryService.findById(entity.getCategory().getId()));
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage());
        return dto;
    }

    public FlowerEntity toEntity(FlowerDTO dto){
        if(dto == null) return null;
        FlowerEntity entity = new FlowerEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCategory(categoryConverter.toEntity(dto.getCategory()));
        entity.setPrice(dto.getPrice());
        entity.setImage(dto.getImage());
        return entity;
    }

    public List<FlowerDTO> toDTO(List<FlowerEntity> entityList){
        List<FlowerDTO> dtoList = new ArrayList<>();
        entityList.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });
        return dtoList;
    }

}
