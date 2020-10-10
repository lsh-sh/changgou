package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: lshsh
 * @Description: 服务注册中心启动类
 */
@SpringBootApplication
@EnableEurekaServer //开启Eureka服务
public class EurekaApplication {

    /**
     * 加载启动类
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
