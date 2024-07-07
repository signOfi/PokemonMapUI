package com.anthony.pokemon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "https://regal-lily-a631f6.netlify.app/",
                        "http://localhost:",
                        "http://localhost:4200",
                        "http://localhost:8080",
                        "http://54.215.203.52",
                        "http://54.215.203.52:8080",
                        "http://ec2-54-215-203-52.us-west-1.compute.amazonaws.com",
                        "http://ec2-54-215-203-52.us-west-1.compute.amazonaws.com:8080"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}