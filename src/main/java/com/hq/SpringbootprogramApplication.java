package com.hq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hq.mapper")
public class SpringbootprogramApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootprogramApplication.class, args);
    }

}
