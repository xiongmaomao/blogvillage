/*
package com.bear.blogvillage.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.bear.blogvillage.user.controller.UserController.*(..))")
    public Object handleMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("pjp start============");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("args is ========"+arg);
        }


        Object obj = pjp.proceed();
        System.out.println("pjp end============");
        return obj;
    }

}
*/
