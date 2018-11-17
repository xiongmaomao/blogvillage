package com.bear.blogvillage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/text")
    public String test(){
        return "hello xiong";
    }
}
