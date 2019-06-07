package com.springboot.bootcrudpage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.springboot.bootcrudpage.dao")
public class BootCrudPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootCrudPageApplication.class, args);
    }

}
