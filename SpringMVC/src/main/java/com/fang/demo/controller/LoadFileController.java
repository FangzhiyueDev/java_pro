package com.fang.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoadFileController {

    @RequestMapping(value = "/loadFile")
    public String loadFile() {
        return "ImageLoad";
    }


}
