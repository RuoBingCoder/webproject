package com.springboot.bootcrudpage.config;

import com.springboot.bootcrudpage.Interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author : 石建雷
 * @date :2019/6/7
 */
@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String url = "/**";
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns(url)
                .excludePathPatterns("/user/index")
                .excludePathPatterns("/user/index.html")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/static/**");


    }


}
