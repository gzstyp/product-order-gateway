package com.example.controller;

import com.example.pojo.Product;
import com.example.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController{

    @Resource
    private ProductService productService;

    @GetMapping("/{id}")
    public Product selectProductById(@PathVariable("id") final Integer id){
        return productService.selectProductById(id);
    }
}