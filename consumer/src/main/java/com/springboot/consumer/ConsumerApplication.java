package com.springboot.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

/**
 * @author JianLeiComputer
 */
@SpringBootApplication
//@EnableDubbo(scanBasePackages = {"com.springboot.springbootprovide.service.impl"})
@EnableDubboConfiguration
@EnableHystrix    //开启熔断器注解
//@ImportResource(locations = {"classpath:boot-consumer.xml"})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
