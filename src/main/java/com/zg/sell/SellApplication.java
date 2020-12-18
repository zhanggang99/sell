package com.zg.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);

    }

}
