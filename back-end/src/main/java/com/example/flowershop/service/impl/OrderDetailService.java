package com.example.flowershop.service.impl;

import com.example.flowershop.converter.OrderDetailConverter;
import com.example.flowershop.dto.OrderDetailDTO;
import com.example.flowershop.model.OrderDetailEntity;
import com.example.flowershop.repository.OrderDetailRepository;
import com.example.flowershop.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailConverter orderDetailConverter;

    @Override
    public List<OrderDetailDTO> getCartByOrderID(int id) {
         List<OrderDetailEntity> list = orderDetailRepository.findByOrder_Id(id);
         if(list == null) return null;
         return orderDetailConverter.toDTO(list);
    }

    @Override
    public int addToCart(int orderID, int flowerID, int quantity) {
        try{

            int result = orderDetailRepository.updateCart(orderID, flowerID, quantity);
            if(result == 0) result = orderDetailRepository.addToCart(orderID, flowerID, quantity);
            return result;
        }catch (Exception err){
            System.out.println(err);
        }
        return 0;
    }

    @Override
    public int updateCart(int cartId, int quantity) {
        try{
            return orderDetailRepository.updateByCartId(cartId, quantity);
        }catch (Exception err){
            System.out.println(err);
        }
        return 0;
    }

    @Override
    public void deleteCartItem(int itemId) {
         orderDetailRepository.deleteById(itemId);

    }
}
