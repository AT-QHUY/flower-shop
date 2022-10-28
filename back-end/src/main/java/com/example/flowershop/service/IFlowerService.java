package com.example.flowershop.service;

import com.example.flowershop.dto.FlowerDTO;

import java.util.List;

public interface IFlowerService {

    public Long getCount();
    public List<FlowerDTO> getAll(int page, int limit);

    public List<FlowerDTO> getAll();

    public FlowerDTO getOneById(int id);

    public List<FlowerDTO> getByName(String name);
}
