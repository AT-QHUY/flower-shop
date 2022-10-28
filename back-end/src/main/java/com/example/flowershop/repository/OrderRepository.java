package com.example.flowershop.repository;

import com.example.flowershop.model.OrderEntity;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    public List<OrderEntity> findByUser_Id(int id);

    public List<OrderEntity> findAll();

    public Optional<OrderEntity> findById(int id);

    public List<OrderEntity> findByStatusAndUser_Id(int status, int id);


    public List<OrderEntity> findByUser_IdAndStatusNotLike(int user_id, int status);

    @Modifying
    @Query(value = "update [order]\n"
                 + "set status = :status\n"
                 + "where id = :order_id"
            ,nativeQuery = true)
    public int updateOrderStatus(@Param(value = "order_id") int order_id, @Param(value = "status") int status);

    @Modifying
    @Query(value = "update [order] \n"
                    + "set user_id = :user_id , status = :status) \n"
                    + "where id = :order_id", nativeQuery = true)
    public int updateOrder(@Param(value = "order_id") int order_id,@Param(value = "user_id") int user_id, @Param(value = "status") int status);

}
