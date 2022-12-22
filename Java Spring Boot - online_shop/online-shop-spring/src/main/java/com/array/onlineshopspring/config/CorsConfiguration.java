//package com.array.onlineshopspring.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfiguration {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("api/v1/**")
//                        .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")
//                        .allowedHeaders("*")
//                        .allowedOrigins("http://localhost:4200")
//                        .exposedHeaders("*") // todo Check if necessary
//                        .allowCredentials(true);
//            }
//        };
//    }
//}
