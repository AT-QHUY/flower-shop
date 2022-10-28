package com.example.flowershop.repository;

import com.example.flowershop.model.FlowerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlowerRepository extends JpaRepository<FlowerEntity, Integer> {

    public Page<FlowerEntity> findAll(Pageable pageable);

    public FlowerEntity findOneById(int id);

    public List<FlowerEntity> findByName(String name);
}
