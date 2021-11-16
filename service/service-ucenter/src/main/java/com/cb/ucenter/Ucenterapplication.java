package com.cb.ucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cb"})
@MapperScan("com.cb.ucenter.mapper")
@EnableDiscoveryClient//nocas注册
public class Ucenterapplication {
    public static void main(String[] args) {
        SpringApplication.run(Ucenterapplication.class,args);
    }
}
