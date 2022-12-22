//package com.array.onlineshopspring.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//import static org.springframework.transaction.TransactionDefinition.withDefaults;
//
//@Configuration
////@EnableWebSecurity // for CORS this one ain't needed
//public class SecurityConfigForCorsWORKS {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((auth) -> {
//                    auth
//                            .anyRequest()
//                            .permitAll();
////                            .authenticated();// for CORS this one ain't needed
//                })
//                .httpBasic(withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
//            }
//        };
//    }
//
//    // for CORS this one ain't needed
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/login", "/register");
//    }
//}
