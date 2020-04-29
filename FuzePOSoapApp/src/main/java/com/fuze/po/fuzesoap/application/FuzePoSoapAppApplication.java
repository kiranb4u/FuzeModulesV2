package com.fuze.po.fuzesoap.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.*" })
public class FuzePoSoapAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FuzePoSoapAppApplication.class, args);
		System.out.println("Welcome to FUZE SOAP APPLICATION!");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FuzePoSoapAppApplication.class);
	}

}
