package com.example.abclabsystem.config;//
//package com.ec.ec.config;
////
////import org.springframework.context.annotation.Configuration;
////import org.springframework.web.servlet.config.annotation.CorsRegistry;
////import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
////
////@Configuration
////public class webConfig implements WebMvcConfigurer {
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/api/**")
////                .allowedOrigins("*")
////                .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS")
////                .allowedHeaders("*")
////                .exposedHeaders("Access-Control-Allow-Origin")
////                .allowCredentials(false).maxAge(3600);
////    }
////}
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class webConfig {
//
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
//            }
//        };
//    }
//}
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
