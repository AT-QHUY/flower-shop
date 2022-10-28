package com.example.flowershop.service.impl;

import com.example.flowershop.converter.OrderConverter;
import com.example.flowershop.dto.OrderDTO;
import com.example.flowershop.model.OrderEntity;
import com.example.flowershop.repository.OrderDetailRepository;
import com.example.flowershop.repository.OrderRepository;
import com.example.flowershop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderConverter orderConverter;


    @Override
    public List<OrderDTO> getAllByUserId(int id) {
        List<OrderEntity> orderList = orderRepository.findByUser_Id(id);
        if (orderList == null) return null;
        return orderConverter.toDTO(orderList);
    }

    @Override
    public List<OrderDTO> getAll() {
        List<OrderEntity> orderList = orderRepository.findAll();
        if(orderList == null) return null;
        return orderConverter.toDTO(orderList);
    }

    @Override
    public List<OrderDTO> getByStatusAndUserId(int status, int id) {
        List<OrderEntity> orderList = orderRepository.findByStatusAndUser_Id(status, id);
        if(orderList == null) return null;
        return orderConverter.toDTO(orderList);
    }

    @Override
    public List<OrderDTO> getAllOrderByUserIdAndNotStatus(int user_id, int status) {
        List<OrderEntity> orderList = orderRepository.findByUser_IdAndStatusNotLike(user_id, status);
        if(orderList == null) return null;
        return orderConverter.toDTO(orderList);
    }


    private int updateOrderStatus(int order_id, int status) {
        int result = orderRepository.updateOrderStatus(order_id, status);
        return result;
    }

    @Override
    public int confirmOrder(int order_id){
        return updateOrderStatus(order_id, 2);
    }

    @Override
    public int addToCart(int user_id, int flower_id, int quantity) {
        try{
            int order_id = 0;
            OrderDTO cart = getCartByUser_Id(user_id);
            if(cart == null){
                OrderEntity entity = orderConverter.toEntity(user_id, 1);
                entity = orderRepository.save(entity);
                if(entity != null) order_id = entity.getId();
            }
            else{
                order_id = cart.getId();
            }
            return orderDetailRepository.addToCart(order_id, flower_id, quantity);

        }catch (Exception ex){
            System.out.println(ex);
            return 0;
        }
    }


    private OrderDTO getCartByUser_Id(int user_id){
        List<OrderDTO> cartList = getByStatusAndUserId(1, user_id);
        if(cartList != null && !cartList.isEmpty()){
            return cartList.get(0);
        }
        return null;
    }
}
