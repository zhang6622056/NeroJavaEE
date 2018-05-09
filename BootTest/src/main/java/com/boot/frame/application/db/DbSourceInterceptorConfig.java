package com.boot.frame.application.db;


import com.boot.frame.application.db.annotation.DbSource;
import com.boot.frame.application.db.datasource.change.ConnectionHolder;
import com.boot.frame.application.db.datasource.change.ConnectionType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * the Intercetpr that filter the annotation DbSource
 *  by spring boot config
 * Created by Nero on 2018-04-16.
 */

@Aspect
@Configuration
public class DbSourceInterceptorConfig {


    private static final Logger logger = LoggerFactory.getLogger(DbSourceInterceptorConfig.class);


    @Pointcut("execution(* com..*.*Mapper.*(..))")
    @Order(1)
    public void declareJointPoint() {}


    @Before("declareJointPoint()")
    public void doBefore(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DbSource dbSource = methodSignature.getMethod().getAnnotation(DbSource.class);
        if(dbSource != null){
            String value = dbSource.value();
            ConnectionType connectionType = new ConnectionType(value);
            ConnectionHolder.set(connectionType);
        }
    }


    @After("declareJointPoint()")
    public void doAfter(){
        ConnectionHolder.release();
    }

}
