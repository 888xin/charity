package com.lhx.charity.utils;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class JavascriptUtil {


    public static Object calByJavaScript(String script, Object[] args) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");//1.得到脚本引擎
        try {
//            ScriptEngineManager sem = new ScriptEngineManager();
//            ScriptEngine engine = sem.getEngineByName("javascript");     //python or jython,
//
//            //定义数学函数
//            //engine.eval("function cal (a, b) {c = a + b; return c; }");
//            engine.eval(script);
//
//            //取得调用接口
//            Invocable jsInvoke = (Invocable) engine;
//
//            //定义加法函数
//
//            Object result1 = jsInvoke.invokeFunction("cal", new Object[] { 10, 5 });
//
//            return result1;


            //2.引擎读取 脚本字符串
            //engine.eval(script);
            //如果js存在文件里，举例
            Resource aesJs = new ClassPathResource(script);
            engine.eval(new FileReader(aesJs.getFile()));

            //3.将引擎转换为Invocable，这样才可以掉用js的方法
            Invocable invocable = (Invocable) engine;

            //4.使用 invocable.invokeFunction掉用js脚本里的方法，第一個参数为方法名，后面的参数为被调用的js方法的入参
            Object result1 = invocable.invokeFunction("decrypt", args);
            return result1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        Object[] args2 = new Object[]{"Llk3gJVkkUImQC/3y7s9JA==", "abcdefgabcdefg12"};
        Object o = calByJavaScript("aes.js", args2);
        System.out.println(o);

    }


}
