package com.liangyuyan.animal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.liangyuyan.animal.dao")
@SpringBootApplication
public class AnimalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalApplication.class, args);
	}

}
