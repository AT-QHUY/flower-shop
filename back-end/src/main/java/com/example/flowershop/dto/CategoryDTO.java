package com.example.flowershop.dto;

import com.example.flowershop.model.FlowerEntity;

import java.util.List;

public class CategoryDTO {

    private int id;

    private String name;

    private List<FlowerEntity> flowerList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlowerEntity> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<FlowerEntity> flowerList) {
        this.flowerList = flowerList;
    }
}
