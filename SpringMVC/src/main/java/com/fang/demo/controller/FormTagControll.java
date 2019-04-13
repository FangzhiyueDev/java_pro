package com.fang.demo.controller;


import com.fang.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * spring 的表单标签的学习的请求处理类
 */

@Controller
public class FormTagControll {

    @RequestMapping(value = "/userInput")
    public String InputUser(Model model, @RequestParam String name, @RequestParam String password) {
        model.addAttribute("user", new User(name, password));
        return "redirect:./jsp/formInputTag.jsp";
    }
}
