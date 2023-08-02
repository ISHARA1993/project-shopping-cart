package com.crickburgerweb.shoppingcart.controller;


import com.crickburgerweb.shoppingcart.Entity.Order;
import com.crickburgerweb.shoppingcart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class OrderController {

    private OrderService orderService;


    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/orders/get-max-number")
    public int getMaxOrderNum() {
        return orderService.getMaxOrderNum();
    }

    @GetMapping("/orders/{id}")
    public Order findByCode(@PathVariable String id) {
        Order theOrder = orderService.findById(id);
        if (theOrder == null) {
            return null;
        }
        return theOrder;
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order theOrder) {
        orderService.save(theOrder);
        return theOrder;
    }

    @PutMapping("/orders")
    public void updateOrder(@RequestBody Order theOrder) {
        orderService.save(theOrder);
        System.out.println("Update success");
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable String id) {
        if (orderService.findById(id) != null) {
            orderService.deleteById(id);
            System.out.println("delete success");
        }
        System.out.println("no Order code");
    }

}
