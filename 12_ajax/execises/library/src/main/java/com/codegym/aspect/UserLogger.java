package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class UserLogger {

//    @AfterThrowing(pointcut = "execution(public * com.codegym.controller.BillController.goPay(..))", throwing = "e")
//    public void checkError(JoinPoint joinPoint, Exception e ) {
//
//    }
}
