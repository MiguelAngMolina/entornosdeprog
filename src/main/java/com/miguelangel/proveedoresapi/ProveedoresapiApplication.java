package com.miguelangel.proveedoresapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.miguelangel.proveedoresapi.model")
public class ProveedoresapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProveedoresapiApplication.class, args);
	}

}
