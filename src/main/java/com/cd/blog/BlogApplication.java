package com.cd.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.cd.blog.dao") //扫描dao接口生成对应的MapperFactory对象，并注册到Spring IoC容器
@EnableTransactionManagement   //开启自动事务管理功能，使用@Transactional注解标注要进行事务管理的方法
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
        System.out.println("项目以启动！");
    }

}