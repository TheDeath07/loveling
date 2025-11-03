package com.loveling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LovelingApplication extends SpringBootServletInitializer
{
    public static void main(String[] args)
    {
        SpringApplication.run(LovelingApplication.class, args);
    }
}
