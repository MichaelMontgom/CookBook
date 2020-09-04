package com.mickey.CookBook;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@Configurable
@ComponentScan
public class CookBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookBookApplication.class, args);
	}

}
