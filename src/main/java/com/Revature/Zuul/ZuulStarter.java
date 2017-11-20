package com.Revature.Zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@RestController
public class ZuulStarter {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "properties/ZuulStarterProperties");
        SpringApplication.run(ZuulStarter.class, args);
    }
}
