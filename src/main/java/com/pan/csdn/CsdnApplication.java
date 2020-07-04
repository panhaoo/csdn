package com.pan.csdn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.pan.csdn.mapper")
public class CsdnApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsdnApplication.class, args);
    }

}
