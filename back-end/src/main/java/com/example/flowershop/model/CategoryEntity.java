package com.example.flowershop.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
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
