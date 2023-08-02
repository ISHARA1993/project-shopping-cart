package com.crickburgerweb.shoppingcart.service;

import com.crickburgerweb.shoppingcart.Entity.Order;

import java.util.List;

public interface OrderService {

    public List<Order> findAll();

    public Order findById(String id);

    public int getMaxOrderNum();

    public void save(Order theOrder);

    public void deleteById(String id);

}
