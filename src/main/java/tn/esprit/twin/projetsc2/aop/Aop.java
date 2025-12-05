package tn.esprit.twin.projetsc2.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Aop {
    @Before("execution(* tn.esprit.twin.projetsc2.services.*.*(..))")
    public void beforServiceMethods(JoinPoint joinPoint){
        String name= joinPoint.getSignature().getName();
        log.info("In method : "+name);
    }

    @After("execution(* tn.esprit.twin.projetsc2.services.*.*(..))")
    public void afterServiceMethods(JoinPoint joinPoint){
        String name= joinPoint.getSignature().getName();
        log.info("Out of method : "+name);
    }

    @AfterReturning(pointcut = "execution(* tn.esprit.twin.projetsc2.services.*.*(..))", returning = "result")
    public void afterReturningServiceMethods(JoinPoint joinPoint, Object result){
        String name= joinPoint.getSignature().getName();
        log.info("Method : "+name+" returned "+result);
    }

    @AfterThrowing(pointcut = "execution(* tn.esprit.twin.projetsc2.services.*.*(..))", throwing = "error")
    public void afterThrowingServiceMethods(JoinPoint joinPoint, Throwable error){
        String name= joinPoint.getSignature().getName();
        log.info("Method : "+name+" threw an exception "+error);
    }
    // Measure execution time of service methods
    @Around("execution(* tn.esprit.twin.projetsc2.services.*.*(..))")
    public Object aroundServiceMethods(ProceedingJoinPoint pjp) throws Throwable {
        long start=System.currentTimeMillis();
        Object obj=pjp.proceed();
        long end=System.currentTimeMillis();
        long duration=end-start;
        String name= pjp.getSignature().getName();
        log.info("Method : "+name+" executed in "+duration+" ms");
        return obj;
    }
}
