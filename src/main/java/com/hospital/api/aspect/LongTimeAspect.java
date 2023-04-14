package com.hospital.api.aspect;


import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LongTimeAspect {

    Logger logger = LoggerFactory.getLogger(LongTimeAspect.class);

    @Around(value = "execution(* com.hospital.api.service.*.Imp..*(..))")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        StringBuilder sb =new StringBuilder("KPI");

        sb.append("[").append(joinPoint.getKind()).append("]\tfor: ").append(joinPoint.getSignature())
                .append("\twithArgs: ").append("(").append(StringUtils.join(joinPoint.getArgs(),",")).append(")");
        sb.append("\ttook :");

        Object returnValue = joinPoint.proceed();
        logger.info(sb.append(System.currentTimeMillis() -  startTime).append("ms.").toString());

        return returnValue;
    }
}
