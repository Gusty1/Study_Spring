package com.gusty.spring6.aop.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面類
@Component //ioc容器
public class LogAspect {

    //前置通知
    @Before(value = "execution(public int com.gusty.spring6.aop.xmlaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知，方法名稱: " + methodName + "， 參數: " + Arrays.toString(args));

    }

    //後置通知
    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->後置通知，方法名稱: " + methodName);

    }

    //返回通知
    @AfterReturning(value = "execution(* com.gusty.spring6.aop.xmlaop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名稱: " + methodName + "， 返回結果: " + result);

    }

    //異常通知
    @AfterThrowing(value = "execution(* com.gusty.spring6.aop.xmlaop.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->異常通知，方法名稱: " + methodName + "， 異常信息: " + ex);

    }

    //環繞通知
    @Around(value = "execution(* com.gusty.spring6.aop.xmlaop.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);

        Object result = null;
        try {
            System.out.println("環繞通知==目標方法之前執行");
            //調用目標方法
            result = joinPoint.proceed();

            System.out.println("環繞通知==目標方法返回值之後執行");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("環繞通知==目標方法出現異常時執行");

        } finally {
            System.out.println("環繞通知==目標方法執行完畢");

        }

        return result;
    }

    //重用切入點表達式
    @Pointcut(value="execution(* com.gusty.spring6.aop.xmlaop.CalculatorImpl.*(..))")
    public void pointCut(){}
}
