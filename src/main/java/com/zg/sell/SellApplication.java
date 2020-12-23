package com.zg.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ServletComponentScan
@ImportResource(locations = ("classpath:spring-mvc.xml"))
@EnableAsync
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);

    }

}
