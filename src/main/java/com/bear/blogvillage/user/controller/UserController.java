package com.bear.blogvillage.user.controller;

import com.bear.blogvillage.exception.UserNotFoundException;
import com.bear.blogvillage.user.po.User;
import com.bear.blogvillage.user.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.impl.conn.Wire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Stream;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(User user){
         userService.insert(user);
        return "";
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "sayHello信息查询")
    public User getInfo(@PathVariable String id) {

       /* if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError)error;
                String m = fieldError.getField()+ "  "+error.getDefaultMessage();
                System.out.println(m);

                    }
            );
        }*/

		//throw new RuntimeException("user not exist");
        //throw new RuntimeException("user hahahaha");
        //throw new UserNotFoundException(id);
        System.out.println("=========="+id);
        User user = new User();
        return user;

    }

}
