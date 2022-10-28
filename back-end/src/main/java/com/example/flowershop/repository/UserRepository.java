package com.example.flowershop.repository;

import com.example.flowershop.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public List<UserEntity> findAll();

//    public UserEntity findOneById(int id);

    public UserEntity findOneByUsername(String name);

    public UserEntity findByUsername(String username);

    public UserEntity findOneById(int id);
}
