package com.array.onlineshopspring;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.array.onlineshopspring")
public class OnlineShopSpringApplication implements CommandLineRunner {

    private static final Logger logger =
            LoggerFactory.getLogger(OnlineShopSpringApplication.class);

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    public static void main(String[] args) {
        logger.info("\nSTARTING : \nOnlineShopSpringApplication starting...");
        SpringApplication.run(OnlineShopSpringApplication.class, args);
        logger.info("\nSTOPPING : \nOnlineShopSpringApplication stopped");
    }


    public void run(String... args) throws Exception {
        logger.info("\nEXECUTING : \ncommand line runner");

    }

}
