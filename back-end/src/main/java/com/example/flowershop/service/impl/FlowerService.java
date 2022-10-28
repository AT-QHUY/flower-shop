package com.example.flowershop.service.impl;

import com.example.flowershop.converter.FlowerConverter;
import com.example.flowershop.dto.FlowerDTO;
import com.example.flowershop.model.FlowerEntity;
import com.example.flowershop.repository.FlowerRepository;
import com.example.flowershop.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerService implements IFlowerService {

    @Autowired
    private FlowerConverter flowerConverter;

    @Autowired
    private FlowerRepository flowerRepository;


    @Override
    public Long getCount() {
        return flowerRepository.count();
    }

    @Override
    public List<FlowerDTO> getAll(int page, int limit) {
        Page<FlowerEntity> entityList = flowerRepository.findAll(PageRequest.of(page-1,limit));
        if(entityList == null) return null;
        return flowerConverter.toDTO(entityList.toList());
    }

    @Override
    public List<FlowerDTO> getAll() {
        List<FlowerEntity> entityList = flowerRepository.findAll();
        if(entityList == null) return null;
        return flowerConverter.toDTO(entityList);
    }

    @Override
    public FlowerDTO getOneById(int id) {
        FlowerEntity entity = flowerRepository.findOneById(id);
        return flowerConverter.toDTO(entity);
    }

    @Override
    public List<FlowerDTO> getByName(String name) {
        List<FlowerEntity> entityList = flowerRepository.findByName(name);
        return flowerConverter.toDTO(entityList);
    }
}
