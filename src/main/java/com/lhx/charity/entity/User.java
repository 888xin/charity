package com.lhx.charity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Component
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable=false,columnDefinition="varchar(32) COMMENT '邮箱地址'")
    private String email;

    @Column(nullable=false,columnDefinition="varchar(16) COMMENT '登录账号'")
    private String name;

    @Column(nullable=false,columnDefinition="varchar(32) COMMENT '密码'")
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
