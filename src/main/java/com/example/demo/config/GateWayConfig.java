package com.example.demo.config;



import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: GateWayConfig
 * @Description:
 * @Author: jiaozongguan
 * @Date: 2021/12/22 17:24
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        RouteLocator build = builder.routes()
                //设置拦截接口
                .route(r -> r.path("/api/user/register/**")
                        //去除路径上第一个参数/api
                        .filters(f -> f.stripPrefix(1)
                                //自定义的filetr
                                .filter(new IpFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://lagou-service-user8080")
                )
                .build();
        return build;
    }

}