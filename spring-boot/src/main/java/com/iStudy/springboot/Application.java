package com.iStudy.springboot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//开启事物
@EnableTransactionManagement  
@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableSwagger2
@EnableAutoConfiguration(exclude={JpaRepositoriesAutoConfiguration.class})
//指定要扫描的mybatis映射类的路径
@MapperScan(basePackages = "com.iStudy.springboot.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
