package com.smallren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.smallren.dao")
public class SpringbootRabbitmqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqDemoApplication.class, args);
    }

}
