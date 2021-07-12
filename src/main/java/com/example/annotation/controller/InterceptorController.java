package com.example.annotation.controller;

import com.example.annotation.MyAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test1")
public class InterceptorController {

    @RequestMapping("/test2")
//    @MyAnnotation
    public Boolean testInterceptor(){
        System.out.println("Controller is running !");
        return true;
    }

}
