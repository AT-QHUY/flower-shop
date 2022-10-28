package com.example.flowershop.converter;

import com.example.flowershop.dto.OrderDetailDTO;
import com.example.flowershop.model.OrderDetailEntity;
import com.example.flowershop.model.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDetailConverter {

    @Autowired
    private FlowerConverter flowerConverter;

    public OrderDetailDTO toDTO(OrderDetailEntity entity){
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        dto.setFlower(flowerConverter.toDTO(entity.getFlower()));
        return dto;
    }

    public List<OrderDetailDTO> toDTO(List<OrderDetailEntity> entity){
        if(entity == null) return null;
        List<OrderDetailDTO> dto = new ArrayList<OrderDetailDTO>();
        entity.forEach(item -> dto.add(toDTO(item)));
        return dto;
    }
}
