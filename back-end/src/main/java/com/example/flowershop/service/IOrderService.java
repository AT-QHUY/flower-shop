package com.example.flowershop.service;

import com.example.flowershop.dto.OrderDTO;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrderService {

    public List<OrderDTO> getAllByUserId(int id);

    public List<OrderDTO> getAll();

    public List<OrderDTO> getByStatusAndUserId(int status, int id);

    public List<OrderDTO> getAllOrderByUserIdAndNotStatus(int user_id, int status);

    public int confirmOrder(int order_id);

    public int addToCart(int user_id, int flower_id, int quantity);
}
