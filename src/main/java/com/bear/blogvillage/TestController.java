package com.bear.blogvillage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("测试一下");
        return "hello xionggq";
    }
}
