package com.crickburgerweb.shoppingcart.dao;

import com.crickburgerweb.shoppingcart.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {


}
