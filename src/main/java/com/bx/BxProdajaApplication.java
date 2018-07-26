package com.bx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan
@SpringBootConfiguration
@SpringBootApplication
@Configuration
public class BxProdajaApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BxProdajaApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BxProdajaApplication.class);
    }  
}
