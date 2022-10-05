package App.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;


@Aspect  // a modularization of a concern that cuts across multiple classes
@Configuration // meta annotation of component
public class LoggingAspect {
    private final Logger logs = LoggerFactory.getLogger(this.getClass());

    @Before("execution (* App.repository.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        logs.info("Intercepted method call of {}", joinPoint.getSignature().getName());
    }
    @After("execution (* App.repository.*.*(..))")
    public void logAfter(JoinPoint joinPoint){
        logs.info("Logging after the method call of {}", joinPoint.getSignature().getName());
    }
    @Around("execution (* App.repository.*.*(..))") // lets you track when a method starts and ends
    public void logMethodExecutionTime(ProceedingJoinPoint pj) throws Throwable {
        // start time
        long startTime = System.currentTimeMillis();
        // for the method to continue execution
        pj.proceed();
        // end time
        long endTime = System.currentTimeMillis();
        // log the difference
        logs.info("Method {} took {} ms to complete", pj.getSignature().getName(), (endTime-startTime));
    }

}
