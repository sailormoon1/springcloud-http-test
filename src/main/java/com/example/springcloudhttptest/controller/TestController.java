package com.example.springcloudhttptest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/gmm")
public class TestController {
    @RequestMapping("/get")
    @ResponseBody
    public String get(){
        return  "hello-gmm";
    }
}
