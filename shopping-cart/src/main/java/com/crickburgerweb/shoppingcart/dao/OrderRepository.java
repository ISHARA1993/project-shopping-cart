package com.crickburgerweb.shoppingcart.dao;

import com.crickburgerweb.shoppingcart.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {

    public List<Order> findByOrderByOrderNumDesc();

}
