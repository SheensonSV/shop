package com.someshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping
    public String SayHello() {
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String bodyHello() {
        return new String("bodyhello");
    }
}
