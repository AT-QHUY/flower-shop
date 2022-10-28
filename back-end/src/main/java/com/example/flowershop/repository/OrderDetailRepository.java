package com.example.flowershop.repository;

import com.example.flowershop.model.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer> {

    public List<OrderDetailEntity> findByOrder_Id(int id);

    @Modifying
    @Query(value = "update orderdetail \n" +
                   "set quantity += :quantity\n" +
                   "where flower_id = :flower_id and order_id = :order_id", nativeQuery = true)
    public int updateCart(@Param("order_id") int orderId, @Param("flower_id") int flowerId, @Param("quantity") int quantity);

    @Modifying
    @Query(value = "insert orderdetail (order_id, flower_id, quantity) \n" +
                    "values (:order_id, :flower_id, :quantity)", nativeQuery = true)
    public int addToCart(@Param("order_id") int orderId, @Param("flower_id") int flowerId, @Param("quantity") int quantity);

    @Modifying
    @Query(value = "update orderdetail \n " +
                    "set quantity = :quantity where id = :cart_id"
                    ,nativeQuery = true)
    public int updateByCartId(@Param("cart_id") int cart_id, @Param("quantity") int quantity);

    public void deleteById(int itemId);

}
