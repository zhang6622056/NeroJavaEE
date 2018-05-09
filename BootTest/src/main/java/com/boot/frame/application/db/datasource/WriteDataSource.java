package com.boot.frame.application.db.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 *
 * Created by Nero on 2018-04-12.
 */
@Configuration
public class WriteDataSource {

    @Value("${spring.datasource.write.url}")
    private String url;
    @Value("${spring.datasource.write.username}")
    private String username;
    @Value("${spring.datasource.write.password}")
    private String password;
    @Value("${spring.datasource.write.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.write.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.write.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.write.maxWait}")
    private long maxWait;
    @Value("${spring.datasource.write.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.write.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${spring.datasource.write.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.write.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.write.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.write.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.datasource.write.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.datasource.write.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.datasource.write.filters}")
    private String filters;



    @Bean(name="overseaWrDataSource")
    public DruidDataSource overseaWrDataSource() throws SQLException {
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
