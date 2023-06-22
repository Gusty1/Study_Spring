package com.gusty.spring6.aop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面類
@Aspect //切面類
@Component //ioc容器
public class LogAspect {

    //設置切入點和通知類型
    //切入點表達式: execution(權限修飾符 增強方法返回類型 增強方法所在類全路徑.方法名稱(方法參數))
    //通知類型有以下5種:

    // 前置: @Before(value="切入點表達式配置切入點")
    //@Before(value="execution(* com.gusty.spring6.aop.annoaop.CalculatorImpl.*(..))")
    @Before(value = "execution(public int com.gusty.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知，方法名稱: " + methodName + "， 參數: " + Arrays.toString(args));

    }

    // 後置: @After()
    // 如果pointcut在不同包裡，前面要加路徑和方法，如下
    //@After(value = "com.gusty.spring6.aop.annoaop.LogAspect.pointCut().pointCut()")
    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->後置通知，方法名稱: " + methodName);

    }

    // 返回: @AfterReturning
    @AfterReturning(value = "execution(* com.gusty.spring6.aop.annoaop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名稱: " + methodName + "， 返回結果: " + result);

    }

    // 異常: @AfterThrowing 獲取到目標方法異常信息
    //目標方法出現異常，會執行這個通知
    @AfterThrowing(value = "execution(* com.gusty.spring6.aop.annoaop.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->異常通知，方法名稱: " + methodName + "， 異常信息: " + ex);

    }

    // 環繞: @Around()
    @Around(value = "execution(* com.gusty.spring6.aop.annoaop.CalculatorImpl.*(..))")
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
    @Pointcut(value="execution(* com.gusty.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void pointCut(){}
}
