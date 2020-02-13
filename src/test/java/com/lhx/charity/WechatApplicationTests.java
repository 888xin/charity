package com.lhx.charity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatApplicationTests {


    @Value("${mails.savePath:Hello Jsp}")
    private String savePath;


    @Test
    public void test() {

    }





}

