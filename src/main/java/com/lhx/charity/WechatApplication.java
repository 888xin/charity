package com.lhx.charity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@EnableAsync
public class WechatApplication extends SpringBootServletInitializer {

    @Value("${mails.sendAttachmentPath:G:/word/send/attachments/}")
    private String sendAttachmentPath;

    public static void main(String[] args) {
        SpringApplication.run(WechatApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(WechatApplication.class);
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(sendAttachmentPath);
        return factory.createMultipartConfig();
    }



}

