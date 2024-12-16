package com.bitspark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.bitspark.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class BitSparkShareBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitSparkShareBackendApplication.class, args);
    }

}
