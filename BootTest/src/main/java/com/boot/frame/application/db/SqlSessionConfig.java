package com.boot.frame.application.db;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Nero on 2018-04-16.
 */
@Configuration
public class SqlSessionConfig {

    @Autowired
    private DataSource switchDataSource;

    @Bean
    public SqlSessionFactoryBean overseaSqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(switchDataSource);
        Properties sqlSessionFactoryProperties = new Properties();
        sqlSessionFactoryProperties.put("mapUnderscoreToCamelCase","true");
        sqlSessionFactoryProperties.put("logPrefix","mybatis.log.");
        sqlSessionFactoryBean.setConfigurationProperties(sqlSessionFactoryProperties);
        return sqlSessionFactoryBean;
    }



    @Bean
    public DataSourceTransactionManager overseaTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(switchDataSource);
        return dataSourceTransactionManager;
    }








}
