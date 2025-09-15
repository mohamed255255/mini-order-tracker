package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Order;

import jakarta.transaction.Transactional;
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {
  
    /// Without @Modifying, an UPDATE or DELETE query will fail , it tells spring that this is not a SELECT query

    @Modifying 
    @Query("UPDATE Order o SET o.description = :#{#order.description},o.price = :#{#order.price}, o.status = :#{#order.status}, o.total_amount = :#{#order.total_amount} WHERE o.id = :id")
    void updateOrder(int id, Order order);


    @Modifying
    @Query("UPDATE Order o SET o.status = :#{#order.status} WHERE o.id = :id")
    void updateOrderStatus(int id, Order order);

}
