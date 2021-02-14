package com.example.controller;

import com.example.pojo.Order;
import com.example.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController{

    @Resource
    private OrderService orderService;

    @GetMapping("/{id}")
    public Order selectProductById(@PathVariable("id") final Integer id){
        return orderService.selectOrderById(id);
    }
}