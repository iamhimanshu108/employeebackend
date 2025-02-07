package com.hky.employe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfig {

    @Value("${frontend.url}")
    private String frontendUrl;

    @Bean
    public WebMvcConfigurer corsConfigurer() {  // Better name for the bean
        return new WebMvcConfigurer() { // Use an anonymous inner class

            @Override
            public void addCorsMappings(CorsRegistry registry) { // Correct method name
                registry.addMapping("/api/**")
                        .allowedOrigins(frontendUrl)
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH") // Correct method name and arguments
                        .allowedHeaders("*")
                        .allowCredentials(true);  // Correct method name
            }
        };
    }
}