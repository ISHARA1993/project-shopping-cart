package com.crickburgerweb.shoppingcart.service;

import com.crickburgerweb.shoppingcart.Entity.Order;
import com.crickburgerweb.shoppingcart.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository theOrderRepository) {
        orderRepository = theOrderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public int getMaxOrderNum() {
        return orderRepository.findByOrderByOrderNumDesc().get(0).getOrderNum();
    }

    @Override
    public Order findById(String id) {
        Optional<Order> result = orderRepository.findById(id);
        if (!result.isPresent()) {
            System.out.println("no product");
            return null;
        }
        return result.get();
    }

    @Override
    public void save(Order theOrder) {
        orderRepository.save(theOrder);
    }

    //new method check
    @Override
    public void deleteById(String theId) {
        orderRepository.deleteById(theId);
    }
}
