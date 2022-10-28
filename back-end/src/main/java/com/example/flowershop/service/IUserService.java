package com.example.flowershop.service;

import com.example.flowershop.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAll();

    UserDTO getOneById(int id);
    UserDTO save(UserDTO dto);

    UserDTO findOneByName(String name);
}
