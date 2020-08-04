package com.web.blog;

import com.web.blog.config.AppProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class WebBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebBlogApplication.class, args);
    }
}
