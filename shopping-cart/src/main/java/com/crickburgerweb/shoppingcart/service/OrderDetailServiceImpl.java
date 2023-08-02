package com.crickburgerweb.shoppingcart.service;

import com.crickburgerweb.shoppingcart.Entity.OrderDetail;
import com.crickburgerweb.shoppingcart.dao.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail findById(String id) {
        Optional<OrderDetail> result = orderDetailRepository.findById(id);
        if (!result.isPresent()) {
            System.out.println("no OrderDetail");
            return null;
        }
        return result.get();
    }

    @Override
    public void save(OrderDetail theOrderDetail) {
        orderDetailRepository.save(theOrderDetail);
    }

    @Override
    public void deleteById(String theId) {
        orderDetailRepository.deleteById(theId);
    }
}
