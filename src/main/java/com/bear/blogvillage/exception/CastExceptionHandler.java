package com.bear.blogvillage.exception;


import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CastExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerUserNotFoundExcetpion(UserNotFoundException ex){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        return result;
    }
}
