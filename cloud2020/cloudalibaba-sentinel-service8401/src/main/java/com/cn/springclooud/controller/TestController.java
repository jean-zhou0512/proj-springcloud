package com.cn.springclooud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/service/test/testA")
    public String getTestA(){
        return ".........test a";
    }

    @RequestMapping("/service/test/testB")
    public String getTestB(){
        return "..........test b";
    }

}
