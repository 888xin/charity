package com.lhx.charity.controller;


import com.lhx.charity.entity.User;
import com.lhx.charity.service.UserService;
import com.lhx.charity.utils.Constants;
import com.lhx.charity.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.io.IOException;


@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @PostMapping(value = "add")
    public void add(@ModelAttribute User user, HttpServletResponse response) throws IOException {
        Result<User> result = userService.add(user);
        if (result.getCode() == Constants.OK){
            request.getSession().setAttribute(Constants.USERNAME, result.getData().getName());
            response.sendRedirect("/starter");
        } else {
            request.getSession().removeAttribute(Constants.USERNAME);
            request.getSession().setAttribute("registerMsg", result.getMsg());
            response.sendRedirect("/register");
        }
    }

    @PostMapping(value = "login")
    public void login(@ModelAttribute User user, HttpServletResponse response) throws IOException {
        Result<User> result = userService.login(user);
        if (result.getCode() == Constants.OK){
            request.getSession().setAttribute(Constants.USERNAME, result.getData().getName());
            response.sendRedirect("/starter");
        } else {
            request.getSession().removeAttribute(Constants.USERNAME);
            request.getSession().setAttribute("loginMsg", result.getMsg());
            response.sendRedirect("/login");
        }
    }







}
