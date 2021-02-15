package com.example.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * 限流规则-令牌桶中的url限流,当然可以弄参数限流,比如某个id只能请求一次;IP限流
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2021-02-15 23:00
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
*/
@Configuration
public class PathKeyResolver{

    @Bean
    public KeyResolver pathKeysResolver(){
        /*return new KeyResolver(){
            @Override
            public Mono<String> resolve(final ServerWebExchange exchange){
                return Mono.just(String.valueOf(exchange.getRequest().getPath()));
            }
        };*/
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());//简写
    }
}