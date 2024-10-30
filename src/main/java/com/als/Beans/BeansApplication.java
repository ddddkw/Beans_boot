package com.als.Beans;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: BeansBoot的启动类
 * @author: dkw
 */
@SpringBootApplication
@MapperScan("com.als.Beans.Blogs.mapper")
public class BeansApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeansApplication.class,args);
    }
}

