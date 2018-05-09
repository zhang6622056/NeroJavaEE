package com.boot.frame.application.db;


import com.boot.frame.application.db.datasource.DynamicSwitchDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by nero on 2018-04-16.
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSource overseaRdDataSource;
    @Autowired
    private DataSource overseaWrDataSource;


    @Bean(name="switchDataSource")
    public DataSource overseaMultiDataSource(){
        DynamicSwitchDataSource dynamicSwitchDataSource = new DynamicSwitchDataSource();
        dynamicSwitchDataSource.setWriteDataSource(overseaWrDataSource);
        dynamicSwitchDataSource.setReadDataSource(overseaRdDataSource);
        return dynamicSwitchDataSource;
    }
}
