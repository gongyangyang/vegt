package com.vegt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.vegt.mapper")
public class VegtApplication {
	public static void main(String[] args) {
		SpringApplication.run(VegtApplication.class, args);
	}

}
