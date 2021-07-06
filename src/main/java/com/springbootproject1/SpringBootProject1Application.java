package com.springbootproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.springbootproject1"})
public class SpringBootProject1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProject1Application.class, args);
    }

}
