package com.example.deliverysystem.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Lang wenchong
 * @Date 2021/12/25 21:55
 * @Version 1.0
 */


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders("origin");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*System.out.println("配置文件已经生效");*/
        registry.addResourceHandler("/static/images/**").addResourceLocations("C:\\Users\\86159\\Desktop\\DeliverySystem\\DeliverySystemBackend\\src\\main\\resources\\static\\images\\");
    }
}
