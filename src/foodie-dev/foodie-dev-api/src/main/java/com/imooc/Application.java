package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// 扫描mybatis通用mapper所在的包
@MapperScan(basePackages = "com.imooc.mapper")
public class Application {

    // com.imooc下的子包都会扫描进去
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}