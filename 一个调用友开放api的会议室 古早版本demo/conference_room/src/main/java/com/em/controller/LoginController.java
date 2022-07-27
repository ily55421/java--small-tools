package com.em.controller;

import org.springframework.stereotype.Controller;

/**
 * Created by Carson on 2017/11/30.
 */
@Controller
public class LoginController {

/*
    //登录跳转
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        return "../../login";
    }

    //登录表单处理
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(User user) throws Exception {

        //Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(user.getId(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();

        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        subject.login(token);

        if (subject.hasRole("admin")) {
            return "redirect:/admin/showRoom";
        } else if (subject.hasRole("ordinary")) {
            return "redirect:/ordinary/showRoom";
        }

        return "/login";
    }
*/

}
