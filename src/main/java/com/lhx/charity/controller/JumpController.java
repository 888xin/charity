package com.lhx.charity.controller;


import com.lhx.charity.entity.User;
import com.lhx.charity.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller()
@RequestMapping("/")
public class JumpController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping(value = "")
    public String login(Model model) {
        User user = new User();
        model.addAttribute(user);

        request.getSession().removeAttribute("loginMsg");
        request.getSession().removeAttribute("registerMsg");
        request.getSession().removeAttribute(Constants.USERNAME);

        return "login";
    }

    @GetMapping(value = "login")
    public String login2(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "login";
    }

    @GetMapping(value = "register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute(user);

//        Object o = request.getSession().getAttribute(Constants.MSG);
//        if (o != null){
//            request.getSession().removeAttribute(Constants.MSG);
//        }

        return "register";
    }

    @GetMapping(value = "forgotPwd")
    public ModelAndView forgotPwd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forgot-password");
        return modelAndView;
    }

    @GetMapping(value = "provision")
    public ModelAndView provision() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("provision");
        return modelAndView;
    }


    @GetMapping(value = "starter")
    public ModelAndView starter() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("starter");
        return modelAndView;
    }

    @GetMapping(value = "contacts")
    public ModelAndView contacts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contacts");
        return modelAndView;
    }
    @GetMapping(value = "data")
    public ModelAndView data() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("data");
        return modelAndView;
    }

    @GetMapping(value = "calendar")
    public ModelAndView calendar() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calendar");
        return modelAndView;
    }




}
