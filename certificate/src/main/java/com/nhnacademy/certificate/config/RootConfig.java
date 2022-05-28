package com.nhnacademy.certificate.config;

import com.nhnacademy.certificate.Base;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
    excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://133.186.211.156:3306/nhn_academy_16");
        dataSource.setUsername("nhn_academy_16");
        dataSource.setPassword("ANQDj5vXfM@1vTo@");
        dataSource.setInitialSize(2);
        dataSource.setMaxTotal(10);
        return dataSource;
    }


}
