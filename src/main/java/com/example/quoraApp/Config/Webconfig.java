package com.example.quoraApp.Config;

import com.example.quoraApp.Filters.Authfilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.core.Ordered;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class Webconfig implements WebMvcConfigurer {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:3000");
//        config.addAllowedOrigin("http://localhost:5173");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//
//        return new CorsFilter(source);
//    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowCredentials(true).allowedOrigins("http://localhost:3000","http://localhost:5173").allowedMethods("GET","POST","PUT","DELETE","OPTIONS");
    }

//    // ONLY FOR INFORMATION FOR INCREASING THE PRECEDENCE OF A FILTER ELEMENT
//    public FilterRegistrationBean corsfilter(){
//        FilterRegistrationBean bean=new FilterRegistrationBean(corsFilter());
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return bean;
//    }
}
