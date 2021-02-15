package com.example.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//自定义网关过滤器(不是全局过滤器)
public class CustomGateWayFilter implements GatewayFilter, Ordered{

    // 通过访问gateway测试 http://127.0.0.1:9000/product/2
    @Override
    public Mono<Void> filter(final ServerWebExchange exchange,final GatewayFilterChain chain){
        System.out.println("自定义网关过滤器(非全局过滤器)已执行");
        return chain.filter(exchange);//继续执行下一个过滤器
    }

    @Override
    public int getOrder(){
        return 0;
    }
}