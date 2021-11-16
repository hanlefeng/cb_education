package com.cb.edu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cb"})
@EnableDiscoveryClient//nocas注册
@EnableFeignClients //调用服务
public class eduApplication {
    public static void main(String[] args) {
        SpringApplication.run(eduApplication.class, args);
    }
}
