package com.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

//(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@ServletComponentScan
@EnableCaching  //s开启缓存
@MapperScan("com.system.mapper")
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		//return super.configure(builder);
		return builder.sources(Application.class);
	}
	public static void main(String[] args) {
		System.out.println("hello Application模块");
		SpringApplication.run(Application.class, args);
		
	}
}
