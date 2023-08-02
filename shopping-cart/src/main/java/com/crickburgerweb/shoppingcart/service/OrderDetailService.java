package com.crickburgerweb.shoppingcart.service;

import com.crickburgerweb.shoppingcart.Entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    public List<OrderDetail> findAll();

    public OrderDetail findById(String id);

    public void save(OrderDetail theOrderDetail);

    public void deleteById(String id);

}
