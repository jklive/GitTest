package com.gw.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.gw.ssm.mapper")//指定扫描mapper接口的位置
@SpringBootApplication
public class SpringBootCrudWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudWorkApplication.class, args);
    }

}
