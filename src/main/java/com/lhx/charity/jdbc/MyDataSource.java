package com.lhx.charity.jdbc;


import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyDataSource {

    SourceEnum value() default SourceEnum.OA;

}
