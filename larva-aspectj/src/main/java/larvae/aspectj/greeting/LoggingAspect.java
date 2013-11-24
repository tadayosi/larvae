package larvae.aspectj.greeting;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("call(* larvae.aspectj.greeting.*.hello(..))")
    public void beforeHello(JoinPoint thisJoinPoint) {
        LOGGER.info("BEFORE: {}", thisJoinPoint.getSignature());
    }

    @After("call(* larvae.aspectj.greeting.*.hello(..))")
    public void afterHello(JoinPoint thisJoinPoint) {
        LOGGER.info("AFTER: {}", thisJoinPoint.getSignature());
    }

    @Around("call(@larvae.aspectj.greeting.Logging * *(..))")
    public Object aroundLogging(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        LOGGER.info("LOGGING: {}", thisJoinPoint.getSignature());
        return thisJoinPoint.proceed();
    }

}
