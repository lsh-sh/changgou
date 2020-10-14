package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: lshsh
 * @Time: 2020/10/14 上午7:41
 * @Description: com.changgou
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //排除掉数据库自动加载
@EnableEurekaClient
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }
}
