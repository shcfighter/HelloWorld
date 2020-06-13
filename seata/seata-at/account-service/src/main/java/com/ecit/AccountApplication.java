package com.ecit;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ecit.mapper")
@EnableDubbo(scanBasePackages = "com.ecit")
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class);
    }
}
