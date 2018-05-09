package com.boot.frame.application.db.datasource;


import com.boot.frame.application.db.datasource.change.ConnectionHolder;
import com.boot.frame.application.db.datasource.change.ConnectionType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * the datasource to sessionFactory that to switch double datasource
 * which between write and read.
 * Created by Nero on 2018-04-16.
 */
public class DynamicSwitchDataSource extends AbstractDataSource implements
        InitializingBean {

    private DataSource writeDataSource;
    private DataSource readDataSource;


    public static final String WRITE_DB = "WRITE";
    public static final String READ_DB = "READ";



    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = writeDataSource.getConnection();
        ConnectionType connectionType = ConnectionHolder.get();
        if(null != connectionType){
            if(WRITE_DB.equals(connectionType.getName())){
                connection =  writeDataSource.getConnection();
            }else if(READ_DB.equals(connectionType.getName())){
                connection =  readDataSource.getConnection();
            }
        }
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(writeDataSource);
        Assert.notNull(readDataSource);
    }



    public void setWriteDataSource(DataSource writeDataSource) {
        this.writeDataSource = writeDataSource;
    }
    public void setReadDataSource(DataSource readDataSource) {
        this.readDataSource = readDataSource;
    }
}
