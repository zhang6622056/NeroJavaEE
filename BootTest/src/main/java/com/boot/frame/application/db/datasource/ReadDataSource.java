package com.boot.frame.application.db.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * Created by admin on 2018-04-12.
 */
@Configuration
public class ReadDataSource {

    @Value("${spring.datasource.read.url}")
    private String url;
    @Value("${spring.datasource.read.username}")
    private String username;
    @Value("${spring.datasource.read.password}")
    private String password;
    @Value("${spring.datasource.read.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.read.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.read.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.read.maxWait}")
    private long maxWait;
    @Value("${spring.datasource.read.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.read.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${spring.datasource.read.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.read.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.read.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.read.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.datasource.read.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.datasource.read.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.datasource.read.filters}")
    private String filters;



    @Bean(name="overseaRdDataSource")
    public DruidDataSource overseaRdDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        druidDataSource.setFilters(filters);
        return druidDataSource;
    }
}
