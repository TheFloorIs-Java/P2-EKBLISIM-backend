
package app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;

@Aspect
@Configuration
public class Logging {
    public static final Logger LOG = LoggerFactory.getLogger(Logging.class);

    @Before("execution (* App.repository.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        Logging.LOG.info("Intercepted method call of {}", joinPoint.getSignature().getName());
    }

    @After("execution (* App.repository.*.*(..))")
    public void logAfter(JoinPoint joinPoint){
        Logging.LOG.info("Logging after the method call of {}", joinPoint.getSignature().getName());
    }

    @Around("execution (* App.repository.*.*(..))") // Tracks when a method starts and ends
    public void logMethodExecutionTime(ProceedingJoinPoint pj) throws Throwable {
        Long startTime = System.currentTimeMillis();
        pj.proceed();
        Long endTime = System.currentTimeMillis();

        Logging.LOG.info("Method {} took {} ms to complete", pj.getSignature().getName(), (endTime-startTime));
    }
}