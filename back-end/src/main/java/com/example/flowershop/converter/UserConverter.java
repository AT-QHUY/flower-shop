package com.example.flowershop.converter;

import com.example.flowershop.dto.UserDTO;
import com.example.flowershop.model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    public UserEntity toEntity(UserDTO dto){
        if(dto == null) return null;
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRolename(dto.getRolename());
        return entity;
    }

    public UserDTO toDTO(UserEntity entity){
        if(entity == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRolename(entity.getRolename());
        return dto;
    }

    public UserEntity toEntity(UserEntity oldEntity, UserDTO newDTO){
        if(newDTO.getName() != null) oldEntity.setName(newDTO.getName());
        if(newDTO.getRolename() != null) oldEntity.setRolename(newDTO.getRolename());
        return oldEntity;
    }

    public List<UserDTO> toDTO(List<UserEntity> enityList){
        List<UserDTO> dtoList = new ArrayList<UserDTO>();
        for (UserEntity entity : enityList) {
            dtoList.add(toDTO(entity));
        }
        return dtoList;
    }
}
