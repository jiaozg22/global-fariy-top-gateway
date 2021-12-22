package com.example.demo.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName: IpFilter
 * @Description:
 * @Author: jiaozongguan
 * @Date: 2021/12/22 17:25
 */
public class IpFilter implements GatewayFilter, Ordered {
    Logger logger = LoggerFactory.getLogger(IpFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders httpHeaders = exchange.getResponse().getHeaders();
        //返回数据格式
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        // 从request对象中获取客户端ip

        logger.info("拦截处理业务");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}