package com.lhx.charity.jdbc;

public class DataSourceContextHolder {

    private static final ThreadLocal<Object> contextHolder = new ThreadLocal<>();

    public static synchronized void setDBType(Object dbType){
        contextHolder.set(dbType);
    }

    public static Object getDBType(){
        return contextHolder.get();
    }

    public static void clearDBType(){
        contextHolder.remove();
    }

}
