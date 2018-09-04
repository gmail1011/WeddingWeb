package com.dongnao.weixinapp;

import com.dongnao.weixinapp.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WeixinappApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinappApplication.class, args);
    }


}
