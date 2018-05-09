package com.boot.frame.application;


import com.boot.frame.application.db.annotation.SecooMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by admin on 2018-04-12.
 */

@SpringBootApplication
@SecooMapperScan(basePackages="${mapper.scan.direct}",sqlSessionFactoryRef="overseaSqlSessionFactory")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}