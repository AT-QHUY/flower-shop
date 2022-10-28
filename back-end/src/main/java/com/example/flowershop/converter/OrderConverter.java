package com.example.flowershop.converter;

import com.example.flowershop.dto.OrderDTO;
import com.example.flowershop.model.OrderEntity;
import com.example.flowershop.repository.UserRepository;
import com.example.flowershop.service.IOrderDetailService;
import com.example.flowershop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderConverter {

    @Autowired
    private IOrderDetailService orderDetailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    public OrderDTO toDTO(OrderEntity entity){
        if(entity == null) return null;
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setStatus(entity.getStatus());
        dto.setListDetail(orderDetailService.getCartByOrderID(entity.getId()));
        return dto;
    }

    public OrderEntity toEntity(OrderDTO dto){
        if(dto == null) return null;
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        entity.setUser(userRepository.findOneById(dto.getUserId()));
        return entity;
    }

    public OrderEntity toEntity(int user_id, int status){
        OrderEntity entity = new OrderEntity();
        entity.setUser(userRepository.findOneById(user_id));
        entity.setStatus(status);
        return entity;
    }

    public List<OrderDTO> toDTO(List<OrderEntity> entityList){
        if(entityList == null) return null;
        List<OrderDTO> dtoList = new ArrayList<>();
        entityList.forEach(entity -> {
            dtoList.add(toDTO(entity));
        });
        return dtoList;
    }



}
