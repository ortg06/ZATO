package com.zato.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan 
public class ZatoApplication {

	public static void main(String[] args)  throws Exception {
		SpringApplication.run(ZatoApplication.class, args);
	}

}
