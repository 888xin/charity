package com.lhx.charity.controller;


import com.lhx.charity.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController()
@RequestMapping("/")
public class JumpController {



    @GetMapping(value = "")
    public ModelAndView file() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置model数据
        //modelAndView.addObject("name", "Hello Spring MVC");
        // 设置视图地址
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping(value = "/authority")
    public Result authority() {
        Result result = new Result<>();
        return result ;
    }





}
