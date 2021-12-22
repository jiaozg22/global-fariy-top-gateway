//package com.example.demo.config;
//
//
//
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//
///**
// * @ClassName: AutoFilter
// * @Description:
// * @Author: Datasure008
// * @Date: 2021/12/22 17:28
// */
//@Configuration
//public class AutoFilter {
//    @Bean
//    @Order(10)
//    public GlobalFilter b() {
//        return (exchange, chain) -> {
//            HttpHeaders httpHeaders = exchange.getResponse().getHeaders();
//            //返回数据格式
//            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//            ServerHttpRequest request = exchange.getRequest();
//            ServerHttpResponse response = exchange.getResponse();
//
//            //业务逻辑
//
//            return chain.filter(exchange);
//        };
//    }
//
//}