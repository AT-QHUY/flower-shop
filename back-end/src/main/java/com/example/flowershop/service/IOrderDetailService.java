package com.example.flowershop.service;

import com.example.flowershop.dto.OrderDetailDTO;
import com.example.flowershop.model.OrderDetailEntity;

import java.util.List;

public interface IOrderDetailService {

    public List<OrderDetailDTO> getCartByOrderID(int id);

    public int addToCart(int userID, int flowerID, int quantity);

    public int updateCart(int cartId, int quantity);

    public void deleteCartItem(int itemId);
}
