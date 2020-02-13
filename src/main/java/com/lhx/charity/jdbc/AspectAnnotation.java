package com.lhx.charity.jdbc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAnnotation {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AspectAnnotation.class);

    @Before("@annotation(myDataSource)")
    public void setDataSource(MyDataSource myDataSource)  {

        DataSourceContextHolder.setDBType(myDataSource.value());

    }


}
