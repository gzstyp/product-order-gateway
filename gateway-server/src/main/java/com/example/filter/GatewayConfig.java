package com.example.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置网关路由,配置多个
@Configuration
public class GatewayConfig{

    @Bean // 通过访问gateway http://127.0.0.1:9000/product/3 http://127.0.0.1:9000/order/3
    public RouteLocator routeLocator(final RouteLocatorBuilder builder){
        return builder.routes().route(route ->
            route.path("/product/**").uri("lb://product-service").filters(new CustomGateWayFilter()).id("product-service")
        ).route(route ->
            route.path("/order/**").uri("lb://order-service").filters(new CustomGateWayFilter()).id("order-service")
        ).build();
    }
}