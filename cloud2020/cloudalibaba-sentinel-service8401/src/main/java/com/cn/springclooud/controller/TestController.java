package com.cn.springclooud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @RequestMapping("/service/test/testA")
    public String getTestA(){
        //暂停毫秒
        try{
        }catch (Exception e){
            e.printStackTrace();
        }
        return ".........test a";
    }

    @RequestMapping("/service/test/testB")
    public String getTestB(){
        System.out.println(new Date());
        return "..........test b";
    }

    @RequestMapping("/service/test/testD")
    public String getTestD(){
//        try{
//            TimeUnit.SECONDS.sleep(1);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("TestD 测试RT");

        System.out.println("TestD 测试异常比例");
        int age= 10/0;
        return "......testD";
    }

    @RequestMapping("/service/test/testE")
    public String getTestE(){
        System.out.println("TestE 测试异常数");
        int age=10/0;
        return "......testE";
    }

    @RequestMapping("/service/test/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(
            @RequestParam(value = "p1",required = false) String p1,
            @RequestParam(value = "p2",required = false)String p2
    ){
        return  "......testF";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "deal_testHotKey";
    }


}
