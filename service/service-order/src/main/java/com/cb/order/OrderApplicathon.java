package com.cb.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cb"})
@MapperScan("com.cb.order.mapper")
@EnableDiscoveryClient//nocas注册
@EnableFeignClients //调用服务
public class OrderApplicathon {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicathon.class,args);
    }
}
