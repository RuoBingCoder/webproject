package com.springboot.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

/**
 * @author JianLeiComputer
 */
@SpringBootApplication
@EnableDubboConfiguration
@EnableHystrix    //开启熔断器注解
@ImportResource(locations = {"classpath:boot-provider.xml"})
@MapperScan(basePackages = {"com.springboot.provider.dao"})
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
