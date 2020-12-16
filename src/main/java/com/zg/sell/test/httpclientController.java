package com.zg.sell.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class httpclientController {

    @GetMapping("/dohttpclienttest")
    public String doGetClientTest(){
        return "dohttpclienttest";
    }
}
