package com.example.demo.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.Order;
import com.example.demo.Repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public ResponseEntity<Map<String, Object>> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> ResponseEntity.ok(
                        Map.of(
                            "message", "Order found",
                            "order",   order
                        )))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of(
                            "message", "Order not found",
                            "order",   new Order()
                        )));
    }

    public ResponseEntity<String> storeOrder(Order order){
        orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order stored successfully");
    }

    public ResponseEntity<String> updateOrder(int id , Order order){
        orderRepository.updateOrder(id, order);
        return ResponseEntity.status(HttpStatus.OK).body("Order updated successfully");

    }

    public ResponseEntity<String> updateOrderStatus(int id , Order order){
        orderRepository.updateOrderStatus(id, order);
        return ResponseEntity.status(HttpStatus.OK).body("Order status updated successfully");
    }

    
}
    