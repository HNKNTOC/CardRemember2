package com.caredRemember2.aspect;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * This aspect for logging methods.
 */
@Aspect
public class AspectLogging {
    private static final Logger LOGGER = LogManager.getLogger(AspectLogging.class);

    @Pointcut("execution(* com.caredRemember2..*.*(..))")
    private void allMethod() {
    }

    @AfterReturning(pointcut = "allMethod()", returning = "returnArg")
    public void logMethodResult(JoinPoint point, Object returnArg) {
        Signature signature = point.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        Object[] args = point.getArgs();
        LOGGER.debug(String.format("%s.%s(%s):%s", className, methodName, Arrays.toString(args), returnArg));
    }

}
