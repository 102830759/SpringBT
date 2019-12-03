package com.hyzx.multidatasource.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author huyue
 * @date 2019/12/3 11:07
 */
@Aspect
@Component
public class DataSourceAspect {
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);
/*    @Before("@annotation(ds)")
    public void beforeDataSource(DataSource ds) {
        DataSourceType value = ds.value();
        DataSourceContextHolder.setDataSource(value);
        LOGGER.info("当前使用的数据源为：{}", value);
    }
    @After("@annotation(ds)")
    public void afterDataSource(DataSource ds){
        DataSourceContextHolder.clearDataSource();
    }*/

    @Before("execution(* com.hyzx.multidatasource.service.impl..*.getMySql*(..))(..))")
    public void setDataSource2test01() {
        DataSourceContextHolder.setDataSource(DataSourceType.db2);
        LOGGER.info("当前使用的数据源为：{}", DataSourceType.db2);
    }

    @After("execution(* com.hyzx.multidatasource.service.impl..*.getMySql*(..))(..))")
    public void after01() {
        DataSourceContextHolder.clearDataSource();
    }

}
