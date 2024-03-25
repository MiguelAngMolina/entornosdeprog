package com.miguelangel.tiendaentornos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.miguelangel.tiendaentornos")
public class TiendaentornosApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendaentornosApplication.class, args);
    }

}
