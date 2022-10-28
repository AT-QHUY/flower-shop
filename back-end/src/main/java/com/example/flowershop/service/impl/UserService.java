package com.example.flowershop.service.impl;

import com.example.flowershop.converter.UserConverter;
import com.example.flowershop.dto.UserDTO;
import com.example.flowershop.model.UserEntity;
import com.example.flowershop.repository.UserRepository;
import com.example.flowershop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAll() {
        List<UserEntity> entityList = userRepository.findAll();
        return userConverter.toDTO(entityList);
    }

    @Override
    public UserDTO getOneById(int id) {
        UserEntity entity = userRepository.findOneById(id);
        return userConverter.toDTO(entity);
    }

    @Override
    public UserDTO save(UserDTO dto) {
        if(dto.getId() ==0){
            UserEntity entity = userConverter.toEntity(dto);
            entity = userRepository.save(entity);
            return userConverter.toDTO(entity);
        }else{
           UserEntity oldEntity = userRepository.findOneById(dto.getId());
           if(oldEntity == null) return null;
           oldEntity = userConverter.toEntity(oldEntity, dto);
           oldEntity = userRepository.save(oldEntity);
           return userConverter.toDTO(oldEntity);
        }

    }

    @Override
    public UserDTO findOneByName(String name) {
        try{
            UserEntity entity = userRepository.findOneByUsername(name);
            if(entity != null) return userConverter.toDTO(entity);
            else return null;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
