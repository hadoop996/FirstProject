package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/http")
public class HttpClientController {

    @RequestMapping("/test01")
    public String test(){
        return "你好";
    }
}
