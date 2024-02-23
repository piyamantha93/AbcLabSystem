package com.example.abclabsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;




@SpringBootApplication
public class AbcLabSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbcLabSystemApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
