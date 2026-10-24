package com.example.jobApp.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JobAppAspect {

    @Before("execution(* com.example.jobApp.service.JobService.*(..))")
    public void beforeExecution(JoinPoint joinPoint){
        System.out.println("Method Called "+joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.jobApp.service.JobService.*(..))")
    public void afterExecutionFinally(JoinPoint joinPoint){     //after finally
        System.out.println("the method execution is tried "+joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.jobApp.service.JobService.*(..))")
    public void afterExecution(JoinPoint joinPoint){     //after full  Execution
        System.out.println("the method method execution is Completed "+joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.jobApp.service.JobService.*(..))")
    public void exceptionOccured(JoinPoint joinPoint){
        System.out.println("the exception is occured"+joinPoint.getSignature().getName());
    }

}
