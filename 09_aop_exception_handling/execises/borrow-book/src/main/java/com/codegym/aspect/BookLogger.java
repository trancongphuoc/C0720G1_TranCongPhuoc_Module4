package com.codegym.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class BookLogger {

    @After("execution(public * com.codegym.service.BookService.save(..))")
    public void checkChange(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String name = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println(className);
        System.out.println(name);
        System.out.println(methodName);
        System.out.println(args);
        System.out.println();
    }

    private static Integer count = 0;
    @Before("execution(public * com.codegym.service.BookService.findAll())")
    public void checkLogin() {
        count++;
        System.out.println(count);
    }

}
