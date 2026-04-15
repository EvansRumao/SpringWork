package com.Project.JobApp.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {


    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    //return type ,class-name.method-name(args)
    @Before("execution(* com.Project.JobApp.service.JobService.*(..)")
    public void logMethodCall(JoinPoint jp){
       logger.info("method called"+jp.getSignature().getName());
    }
}
