package com.hospital.api.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LongingAspect {


    Logger log = LoggerFactory.getLogger(LongingAspect.class);

   @Around(value = "execution(* com.hospital.api..*(..))")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("KPI:");
        sb.append("[").append(joinPoint.getKind()).append("]\tfor: ").append(joinPoint.getSignature())
                .append("\twithArgs: ").append("(").append(StringUtils.join(joinPoint.getArgs(), ",")).append(")");
        sb.append("\ttook: ");
        Object returnValue = joinPoint.proceed();
        log.info(sb.append(System.currentTimeMillis() - startTime).append(" ms.").toString());

        return returnValue;
    }


    @Pointcut(value = "execution(* com.hospital.api.repository..*(..))")
    public void forRepositoryLog(){}

    @Pointcut(value = "execution(* com.hospital.api.controller..*(..))")
    public void forControllerLog(){}

    @Pointcut(value = "execution(* com.hospital.api.service..*(..))")
    public void forServiceLog(){}

    @Pointcut(value = "forControllerLog() || forServiceLog() || forRepositoryLog()")
    public void forAllApp(){}

    @Before(value = "forAllApp()")
    public void beforeMethod(JoinPoint joinPoint){

        String methodName = joinPoint.getSignature().toShortString();

        log.info("====> Method Name is >> {}",methodName);

        Object [] args = joinPoint.getArgs();

        for (Object arg:args) {

            log.info("====> argument >> {}",arg);
        }
    }
}
