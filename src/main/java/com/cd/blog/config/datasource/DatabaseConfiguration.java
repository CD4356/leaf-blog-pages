package com.cd.blog.config.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration  //标注@Configuration，表明这是一个配置类，相当于spring的xml配置文件
public class DatabaseConfiguration {

    @Bean   //注册组件到IoC容器
    @Primary   //使用当前当前数据库连接池作为默认数据库连接池
    @ConfigurationProperties(prefix = "spring.datasource")  //将配置文件中指定的值绑定到组件对应的属性中
    public DataSource dataSource(){
        return new ComboPooledDataSource();
        //return DataSourceBuilder.create().type(return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();.class).build();
    }

}
