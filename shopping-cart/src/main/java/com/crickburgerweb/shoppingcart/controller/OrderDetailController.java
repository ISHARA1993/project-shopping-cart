package com.crickburgerweb.shoppingcart.controller;


import com.crickburgerweb.shoppingcart.Entity.OrderDetail;
import com.crickburgerweb.shoppingcart.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class OrderDetailController {

    private OrderDetailService orderDetailService;


    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/order-details")
    public List<OrderDetail> findAll() {
        return orderDetailService.findAll();
    }

    @GetMapping("/order-details/{id}")
    public OrderDetail findByCode(@PathVariable String id) {
        OrderDetail theOrderDetail = orderDetailService.findById(id);
        if (theOrderDetail == null) {
            return null;
        }
        return theOrderDetail;
    }

    @PostMapping("/order-details")
    public OrderDetail addOrder(@RequestBody OrderDetail orderDetail) {
        orderDetailService.save(orderDetail);
        return orderDetail;
    }

    @PutMapping("/order-details")
    public void updateOrder(@RequestBody OrderDetail orderDetail){
        orderDetailService.save(orderDetail);
        System.out.println("Update success");
    }

    @DeleteMapping("/order-details/{id}")
    public void deleteOrder(@PathVariable String id){
        if(orderDetailService.findById(id)!=null){
            orderDetailService.deleteById(id);
            System.out.println("delete success");
        }
        System.out.println("no Order detail");
    }

}
